package com.example.HttpServerExercise8.exeptions;

import lombok.Getter;
import org.apache.logging.log4j.Logger;

@Getter
public class CalculateException extends Exception {

    public CalculateException(ErrMsg errMsg) {
        super(errMsg.getMsg());
    }

    public CalculateException(ErrMsg errMsg, String... args) {
        super(String.format(errMsg.getMsg(), args));
    }
}