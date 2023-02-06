package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.LoggerException;

public interface LoggerManager {
    String getLoggerLevel(String loggerName) throws LoggerException;

    String setLoggerLevel(String loggerName, String loggerLevel) throws LoggerException;
}