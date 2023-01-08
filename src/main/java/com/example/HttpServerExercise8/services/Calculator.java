package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.CalculateException;
import org.apache.logging.log4j.Logger;

import java.util.List;

public interface Calculator {
    int calc(String operationStr, List<Integer> arguments) throws CalculateException;
}
