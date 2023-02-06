package com.example.HttpServerExercise8.advice;

import com.example.HttpServerExercise8.controllers.StackController;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {StackController.class})
@Getter
public class StackControllerAdvice extends ControllerAdvice {

    private final String loggerName = "stack-logger";
}

