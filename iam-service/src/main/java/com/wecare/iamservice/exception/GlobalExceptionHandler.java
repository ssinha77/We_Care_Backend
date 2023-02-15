package com.wecare.iamservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Error> resourceNotFound(AuthenticationException ex, WebRequest req){
        Error error = new Error(ex.getMessage(), HttpStatus.UNAUTHORIZED.toString(), Date.from(Instant.now()));
        return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
}
