package com.example.HttpServerExercise8.enums;

import lombok.Getter;

@Getter
public enum Operation {
    PLUS(2),
    MINUS(2),
    TIMES(2),
    DIVIDE(2),
    POW(2),
    ABS(1),
    FACT(1);

    private final int argumentAmount;

    Operation(int argumentAmount) {
        this.argumentAmount = argumentAmount;
    }
}