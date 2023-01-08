package com.example.HttpServerExercise8.utils;

import com.example.HttpServerExercise8.enums.Operation;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.exeptions.ErrMsg;

public class  CalcValidator {

    public static Operation validateReq(String operationStr, int argumentsAmount) throws CalculateException {
        int expectedArgumentAmount;

        Operation operation = validateOperation(operationStr);
        expectedArgumentAmount = operation.getArgumentAmount();
        actualArgsAmountVsExpected(argumentsAmount, expectedArgumentAmount, operation);

        return operation;
    }

    public static Operation validateOperation(String operationStr) throws CalculateException {
        try {
            return Operation.valueOf(operationStr.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new CalculateException(ErrMsg.NO_SUCH_OPERATION, operationStr);
        }
    }

    private static void actualArgsAmountVsExpected(int actual, int expected, Operation operation) throws CalculateException {
        if (actual > expected) {
            throw new CalculateException(ErrMsg.TOO_MANY_ARGUMENTS, operation.name());
        } else if (actual < expected) {
            throw new CalculateException(ErrMsg.NOT_ENOUGH_ARGUMENTS, operation.name());
        }
    }
}
