package com.skill.taskproject.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFound extends RuntimeException {
    private String message;

    public TaskNotFound(String message) {
        super(message);
        this.message = message;
    }


}
