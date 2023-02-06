package com.example.HttpServerExercise8.advice;

import com.example.HttpServerExercise8.controllers.IndependentController;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {IndependentController.class})
@Getter
public class IndependentControllerAdvice extends ControllerAdvice {

    private final String loggerName = "independent-logger";
}
