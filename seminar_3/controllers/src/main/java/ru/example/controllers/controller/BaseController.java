package ru.example.controllers.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public class BaseController {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<RestControllerSample.BaseResponse> handleException(RuntimeException e) {
        log.error("Handled exception", e);
        return new ResponseEntity<>(
                new RestControllerSample.BaseResponse("ERROR"),
                HttpStatusCode.valueOf(500)
        );
    }

}
