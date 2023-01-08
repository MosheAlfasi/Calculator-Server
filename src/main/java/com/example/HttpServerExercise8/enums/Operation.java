package com.example.HttpServerExercise8.enums;

import lombok.Getter;

@Getter
public enum Operation {
    plus(2),
    minus(2),
    times(2),
    divide(2),
    pow(2),
    abs(1),
    fact(1);

    private int argumentAmount;

    Operation(int argumentAmount) {
        this.argumentAmount = argumentAmount;
    }
}
