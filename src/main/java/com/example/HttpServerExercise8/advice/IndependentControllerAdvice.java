package com.example.HttpServerExercise8.advice;

import com.example.HttpServerExercise8.controllers.IndependentController;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.response.FailedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = {IndependentController.class})
public class IndependentControllerAdvice {
    private final Logger logger = LogManager.getLogger("independent-logger");

    @ExceptionHandler(value = {CalculateException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public FailedResponse handler(CalculateException e) {
        logger.error("Server encountered an error ! message: {}", e.getMessage());

        return new FailedResponse(e.getMessage());
    }
}
