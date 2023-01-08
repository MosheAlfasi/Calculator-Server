package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndependentCalcImpl implements IndependentCalc {
    private final Calculator calculator;
    private final Logger logger = LogManager.getLogger("independent-logger");

    public int performOperation(List<Integer> arguments, String operationStr) throws CalculateException {
        int result = calculator.calc(operationStr, arguments);
        logger.info("Performing operation {}. Result is {}", operationStr, result);
        logger.debug("Performing operation: {}({}) = {}", operationStr, AppUtils.getStrArr(arguments), result);

        return result;
    }
}