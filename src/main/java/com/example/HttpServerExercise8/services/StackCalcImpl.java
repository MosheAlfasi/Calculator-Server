package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.enums.Operation;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.exeptions.ErrMsg;
import com.example.HttpServerExercise8.utils.AppUtils;
import com.example.HttpServerExercise8.utils.CalcValidator;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StackCalcImpl implements StackCalc{
    private final Logger logger = LogManager.getLogger("stack-logger");
    private final Calculator calculator;
    private final Stack<Integer> stack = new Stack<>();

    public int getStackSize(boolean withLogs) {
        if (withLogs) {
            logger.info("Stack size is {}", stack.size());
            logger.debug("Stack content (first == top): [{}]", AppUtils.getStackStrReverseOrder(stack));
        }

        return stack.size();
    }

    public void addArguments(List<Integer> arguments) {
        arguments.forEach(arg -> stack.add(arg));
        logger.info("Adding total of {} argument(s) to the stack | Stack size: {}", arguments.size(), stack.size());
        logger.debug("Adding arguments: {} | Stack size before {} | stack size after {}", AppUtils.getStrArr(arguments), stack.size() - arguments.size(), stack.size());
    }

    public void removeArguments(int amount) throws CalculateException {
        if (getStackSize(false) < amount) {
            throw new CalculateException(ErrMsg.CANNOT_REMOVE_FROM_STACK, String.valueOf(amount), String.valueOf(getStackSize(false)));
        }

        for (int i = 0 ; i < amount ; i++) {
            stack.pop();
        }

        logger.info("Removing total {} argument(s) from the stack | Stack size: {}", amount, stack.size());
    }

    public int performOperation(String operationStr) throws CalculateException {
        int result, numOfOperationArgs;
        List<Integer> arguments;
        Operation operation;

        operation = CalcValidator.validateOperation(operationStr);
        numOfOperationArgs = operation.getArgumentAmount();
        validateStackSize(numOfOperationArgs, operation);

        arguments = getArgsFromStack(numOfOperationArgs);
        result = calculator.calc(operationStr, arguments);

        logger.info("Performing operation {}. Result is {} | stack size: {}", operation.name(), result, stack.size());
        logger.debug("Performing operation: {}({}) = {}", operation.name(), AppUtils.getStrArr(arguments), result);

        return result;
    }

    private void validateStackSize(int numOfOperationArgs, Operation operation) throws CalculateException {
        if (getStackSize(false) < numOfOperationArgs) {
            throw new CalculateException(ErrMsg.NOT_ENOUGH_STACK_ARGUMENTS, operation.name(), String.valueOf(numOfOperationArgs), String.valueOf(getStackSize(false)));
        }
    }

    private List<Integer> getArgsFromStack(int amount) {
        List<Integer> arguments = new ArrayList<>();

        for (int i = 0 ; i < amount ; i++) {
            arguments.add(stack.pop());
        }

        return arguments;
    }
}
