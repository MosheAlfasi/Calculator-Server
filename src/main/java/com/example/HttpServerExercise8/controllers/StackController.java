package com.example.HttpServerExercise8.controllers;

import com.example.HttpServerExercise8.annotations.InitLog;
import com.example.HttpServerExercise8.enums.HttpVerb;
import com.example.HttpServerExercise8.exeptions.CalculateException;
import com.example.HttpServerExercise8.request.StackAddArgsBody;
import com.example.HttpServerExercise8.response.SuccessResponse;
import com.example.HttpServerExercise8.services.StackCalc;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stack")
@RequiredArgsConstructor
public class StackController {
    private final StackCalc stackCalc;

    @GetMapping("/size")
    @ResponseStatus(HttpStatus.OK)
    @InitLog(resourceName = "/stack/size", httpVerb = HttpVerb.GET)
    public SuccessResponse getStackSize() {
        int result = stackCalc.getStackSize(true);

        return new SuccessResponse(result);
    }

    @PutMapping("/arguments")
    @ResponseStatus(HttpStatus.OK)
    @InitLog(resourceName = "/stack/arguments", httpVerb = HttpVerb.PUT)
    public SuccessResponse addArguments(@RequestBody StackAddArgsBody body) {
        stackCalc.addArguments(body.getArguments());

        return new SuccessResponse(stackCalc.getStackSize(false));
    }

    @GetMapping("/operate")
    @ResponseStatus(HttpStatus.OK)
    @InitLog(resourceName = "/stack/operate", httpVerb = HttpVerb.GET)
    public SuccessResponse performOperation(@RequestParam String operation) throws CalculateException {
        int result = stackCalc.performOperation(operation);

        return new SuccessResponse(result);
    }

    @DeleteMapping("/arguments")
    @ResponseStatus(HttpStatus.OK)
    @InitLog(resourceName = "/stack/arguments", httpVerb = HttpVerb.DELETE)
    public SuccessResponse removeArgs(@RequestParam String count) throws CalculateException {
        stackCalc.removeArguments(Integer.valueOf(count));

        return new SuccessResponse(stackCalc.getStackSize(false));
    }
}
