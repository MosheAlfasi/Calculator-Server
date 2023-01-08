package com.example.HttpServerExercise8.annotations;

import com.example.HttpServerExercise8.enums.HttpVerb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InitLog {
    String resourceName();
    HttpVerb httpVerb();
}
