package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.ErrMsg;
import com.example.HttpServerExercise8.exeptions.LoggerException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerManagerImpl implements LoggerManager {
    @Override
    public String getLoggerLevel(String loggerName) throws LoggerException {
        try {
            Level loggerLevel = LogManager.getLogger(loggerName).getLevel();

            return loggerLevel.name().toUpperCase();
        } catch (Exception e) {
            throw new LoggerException(ErrMsg.ERROR_LOGGER_REQUEST, e.getMessage());
        }
    }

    @Override
    public String setLoggerLevel(String loggerName, String loggerLevel) throws LoggerException {
        Level level = validateLogLevel(loggerLevel);
        Logger logger = LogManager.getLogger(loggerName);

        Configurator.setLevel(logger, level);

        return level.name();
    }

    private Level validateLogLevel(String loggerLevel) throws LoggerException {
        try {
            return Level.valueOf(loggerLevel);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new LoggerException(ErrMsg.INVALID_LOGGER_LEVEL, loggerLevel);
        }
    }
}
