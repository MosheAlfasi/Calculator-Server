package com.example.HttpServerExercise8.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class AppUtils {
    public static String getStrArr(List<Integer> arr) {
        return arr.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public static String getStackStrReverseOrder(Stack stack) {
        String result = "";
        String tmp = "";
        boolean isStartStr = true;
        List<Object> list = Arrays.stream(stack.toArray()).collect(Collectors.toList());

        for (Object item : list) {
            tmp = item + (isStartStr ? "" : ", ");
            result = tmp + result;
            isStartStr = false;
        }

        return result;
    }
}
