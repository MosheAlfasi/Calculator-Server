package com.example.HttpServerExercise8.request;

import lombok.Data;

import java.util.List;

@Data
public class IndependentBody {
    private List<Integer> arguments;
    private String operation;
}
