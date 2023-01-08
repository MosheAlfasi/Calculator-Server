package com.example.HttpServerExercise8.controllers;

import com.example.HttpServerExercise8.annotations.InitLog;
import com.example.HttpServerExercise8.enums.HttpVerb;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.request.IndependentBody;
import com.example.HttpServerExercise8.response.SuccessResponse;
import com.example.HttpServerExercise8.services.IndependentCalc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("independent")
@RequiredArgsConstructor
public class IndependentController {
    private final IndependentCalc independentCalc;

    @PostMapping("/calculate")
    @InitLog(resourceName = "/independent/calculate", httpVerb = HttpVerb.POST)
    @ResponseStatus(HttpStatus.OK)
    public SuccessResponse calculate (@RequestBody IndependentBody body) throws CalculateException {
        int result = independentCalc.performOperation(body.getArguments(), body.getOperation());

        return new SuccessResponse(result);
    }
}
