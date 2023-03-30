package ru.edu.springliquibase.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(
        NotFoundException notFoundException, WebRequest request
    ) {
        return handleExceptionInternal(
            notFoundException, Map.of("error", notFoundException.getMessage()),
            new HttpHeaders(), HttpStatus.NOT_FOUND, request
        );
    }

    @ExceptionHandler(value = {IllegalBookingException.class})
    protected ResponseEntity<Object> handleIllegalBookingException(
        IllegalBookingException exception, WebRequest request
    ) {
        return handleExceptionInternal(
            exception, Map.of("error", exception.getMessage()),
            new HttpHeaders(), HttpStatus.BAD_REQUEST, request
        );
    }

}
