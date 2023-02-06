package com.example.HttpServerExercise8.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class Counter {
    private int counter;

    @PostConstruct
    private void init() {
        counter = 0;
    }

    public void incrementBy1() {
        ++counter;
    }
}