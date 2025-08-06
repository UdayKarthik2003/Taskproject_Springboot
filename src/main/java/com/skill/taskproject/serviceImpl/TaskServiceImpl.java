package com.skill.taskproject.serviceImpl;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skill.taskproject.entity.Task;
import com.skill.taskproject.entity.Users;
import com.skill.taskproject.exception.ApiException;
import com.skill.taskproject.exception.UserNotFound;
import com.skill.taskproject.payload.TaskDto;
import com.skill.taskproject.repository.TaskRepository;
import com.skill.taskproject.repository.UserRepository;
import com.skill.taskproject.service.TaskService;
@Service

public class TaskServiceImpl implements TaskService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskDto saveTask(long userid, TaskDto taskDto) {
        Users user = userRepository.findById(userid).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found:", userid)));
        Task task = modelMapper.map(taskDto, Task.class);
        task.setUser(user);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskDto.class);
    }
    @Override
    public List<TaskDto> getAllTasks(long user_id){
        userRepository.findById(user_id).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found:", user_id)));
        List<Task> tasks=taskRepository.findAllByUser_Id(user_id);
        return tasks.stream().map(
            task -> modelMapper.map(task, TaskDto.class)
        ).toList()  
        ;
    }

    @Override
    public TaskDto getTask(long userid, long taskid) {
        Users user = userRepository.findById(userid).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found:", userid)));
        Task task = taskRepository.findById(taskid).orElseThrow(() -> new UserNotFound(String.format("Task Id %d not found for User Id %d:", taskid, userid)));
        if (user.getId()!=task.getUser().getId()) {
            throw new ApiException("Task Id %d is not belong to User Id %d".formatted(taskid, userid) );
        }
        return modelMapper.map(task, TaskDto.class);
    }
    @Override
    public void  deleteTask(long userid, long taskid) {
        Users user = userRepository.findById(userid).orElseThrow(() -> new UserNotFound(String.format("User Id %d not found:", userid)));
        Task task = taskRepository.findById(taskid).orElseThrow(() -> new UserNotFound(String.format("Task Id %d not found for User Id %d:", taskid, userid)));
        if (user.getId() != task.getUser().getId()) {
            throw new ApiException("Task Id %d is not belong to User Id %d".formatted(taskid, userid));
        }
        taskRepository.deleteById(taskid);
    }
}
