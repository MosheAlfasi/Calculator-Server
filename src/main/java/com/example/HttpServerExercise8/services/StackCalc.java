package com.example.HttpServerExercise8.services;

import com.example.HttpServerExercise8.exeptions.CalculateException;

import java.util.List;

public interface StackCalc {
    int getStackSize(boolean withLogs);
    void addArguments(List<Integer> arguments);
    void removeArguments(int amount) throws CalculateException;
    int performOperation(String operationStr) throws CalculateException;
}