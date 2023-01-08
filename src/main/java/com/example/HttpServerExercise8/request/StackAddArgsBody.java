package com.example.HttpServerExercise8.request;

import lombok.Data;

import java.util.List;

@Data
public class StackAddArgsBody {
    private List<Integer> arguments;
}
