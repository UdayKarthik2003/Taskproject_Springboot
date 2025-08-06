package com.skill.taskproject.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException {
    private String message  ;

    public ApiException(String message) {
        super(message);
        this.message = message;
    }

}
