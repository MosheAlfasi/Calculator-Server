package com.example.HttpServerExercise8.advice;

import com.example.HttpServerExercise8.controllers.LoggerController;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {LoggerController.class})
@Getter
public class logsControllerAdvice extends ControllerAdvice {

    private final String loggerName = "manageLog-logger";
}
