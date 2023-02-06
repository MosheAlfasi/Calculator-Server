package com.example.HttpServerExercise8.exeptions;

public class LoggerException extends Exception {
    public LoggerException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }

    public LoggerException(ErrMsg errMsg, String... args) {
        super(String.format(errMsg.getMsg(), args));
    }
}