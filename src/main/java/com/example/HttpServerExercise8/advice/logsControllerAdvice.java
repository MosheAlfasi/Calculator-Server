package com.example.HttpServerExercise8.advice;

import com.example.HttpServerExercise8.controllers.LoggerController;
import com.example.HttpServerExercise8.exeptions.LoggerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {LoggerController.class})
public class logsControllerAdvice {

    @ExceptionHandler(value = {LoggerException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handler(LoggerException e) {
        return "Failure:" + e.getMessage();
    }
}
