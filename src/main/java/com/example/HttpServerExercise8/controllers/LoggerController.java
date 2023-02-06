package com.example.HttpServerExercise8.controllers;

import com.example.HttpServerExercise8.annotations.InitLog;
import com.example.HttpServerExercise8.enums.HttpVerb;
import com.example.HttpServerExercise8.exeptions.LoggerException;
import com.example.HttpServerExercise8.response.SuccessResponse;
import com.example.HttpServerExercise8.services.LoggerManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("logs")
@RequiredArgsConstructor
public class LoggerController {

    private final LoggerManager loggerManager;

    @GetMapping("/level")
    @InitLog(resourceName = "/logs/level", httpVerb = HttpVerb.GET)
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse getLoggerLevel(@RequestParam(name = "logger-name") String loggerName) throws LoggerException {
        return new SuccessResponse(loggerManager.getLoggerLevel(loggerName));
    }

    @PutMapping("/level")
    @InitLog(resourceName = "/logs/level", httpVerb = HttpVerb.PUT)
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse setLoggerLevel(@RequestParam(name = "logger-name") String loggerName, @RequestParam(name = "logger-level") String loggerLevel) throws LoggerException {
        return new SuccessResponse(loggerManager.setLoggerLevel(loggerName, loggerLevel));
    }
}