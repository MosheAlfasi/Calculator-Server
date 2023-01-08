package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.enums.Operation;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.exeptions.ErrMsg;
import com.example.HttpServerExercise8.utils.CalcValidator;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

    public int calc(String operationStr, List<Integer> arguments) throws CalculateException {
        int res = 0;
        Operation operation = CalcValidator.validateReq(operationStr, arguments.size());

        switch (operation) {
            case plus:
                res = plus(arguments.get(0), arguments.get(1));
                break;
            case minus:
                res = minus(arguments.get(0), arguments.get(1));
                break;
            case times:
                res = times(arguments.get(0), arguments.get(1));
                break;
            case divide:
                res = divide(arguments.get(0), arguments.get(1));
                break;
            case pow:
                res = pow(arguments.get(0), arguments.get(1));
                break;
            case abs:
                res = abs(arguments.get(0));
                break;
            case fact:
                res = fact(arguments.get(0));
                break;
        }

        return res;
    }

    private int plus(int a, int b) {
        return a + b;
    }

    private int minus(int a, int b) {
        return a - b;
    }

    private int times(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) throws CalculateException {
        if (b == 0) {
            throw new CalculateException(ErrMsg.DIVIDE_BY_ZERO);
        }

        return a / b;
    }

    private int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }

    private int abs(int a) {
        return Math.abs(a);
    }

    private int fact(int a) throws CalculateException {
        int result = 1;

        if (a < 0) {
            throw new CalculateException(ErrMsg.FACTORIAL_NOT_SUPPORTED_NEGATIVE_NUMBER);
        }

        for(int i =1 ; i <= a ; i++){
            result *= i;
        }

        return result;
    }
}
