package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.CalculateException;

import java.util.List;

public interface IndependentCalc {
    int performOperation(List<Integer> arguments, String operationStr) throws CalculateException;
}