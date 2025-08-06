package com.skill.taskproject.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skill.taskproject.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task save(Task task);
    List<Task> findAllByUser_Id( Long user_id);
}