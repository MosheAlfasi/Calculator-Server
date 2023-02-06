package com.example.HttpServerExercise8.exeptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    DIVIDE_BY_ZERO("Error while performing operation Divide: division by 0"),
    FACTORIAL_NOT_SUPPORTED_NEGATIVE_NUMBER("Error while performing operation Factorial: not supported for the negative number"),
    NO_SUCH_OPERATION("Error: unknown operation: %s"),
    NOT_ENOUGH_ARGUMENTS("Error: Not enough arguments to perform the operation %s"),
    TOO_MANY_ARGUMENTS("Error: Too many arguments to perform the operation %s"),
    NOT_ENOUGH_STACK_ARGUMENTS("Error: cannot implement operation %s. It requires %s arguments and the stack has only %s arguments"),
    CANNOT_REMOVE_FROM_STACK("Error: cannot remove %s from the stack. It has only %s arguments"),
    INVALID_LOGGER_LEVEL("Error: logger level %s is invalid."),
    ERROR_LOGGER_REQUEST("Error: %s");

    private final String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }
}