package com.skill.taskproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skill.taskproject.entity.Users;
import com.skill.taskproject.payload.TaskDto;
import com.skill.taskproject.service.TaskService;
@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;
    //Save tasks
    @PostMapping("/{Userid}/tasks")
    public ResponseEntity<TaskDto> saveTask(@PathVariable(name="Userid") long userid, @RequestBody TaskDto taskDto) {
        
        return new ResponseEntity<>(taskService.saveTask(userid, taskDto),HttpStatus.CREATED);
    }
    //Get all tasks
    @GetMapping("/{Userid}/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name="Userid") long userid) {
        return new ResponseEntity<>(taskService.getAllTasks(userid), HttpStatus.OK);
    }
    //Get indv tast
    @GetMapping("/{Userid}/tasks/{taskid}")
    public ResponseEntity<TaskDto> getTask(@PathVariable(name="Userid") long userid, @PathVariable(name="taskid") long taskid) {
        return new ResponseEntity<>(taskService.getTask(userid, taskid), HttpStatus.OK);
    } 
    //del indv tast
    @DeleteMapping("/{Userid}/tasks/{taskid}")
    public ResponseEntity<String> deleteTask(@PathVariable(name="Userid") long userid, @PathVariable(name="taskid") long taskid) {
        taskService.deleteTask(userid, taskid);
        return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);
    } 
}
