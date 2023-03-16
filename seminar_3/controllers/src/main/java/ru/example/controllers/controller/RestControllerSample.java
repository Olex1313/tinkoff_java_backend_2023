package ru.example.controllers.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.controllers.exception.BusinessException;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestControllerSample extends BaseController {

    record BaseResponse(String data) {}

    @GetMapping("/1")
    public ResponseEntity<BaseResponse> unstableMethodWithRE() {
        throw new BusinessException("message");
    }

    @GetMapping("/2")
    public ResponseEntity<BaseResponse> unstableMethodWithIE() {
        throw new IllegalArgumentException();
    }

}

