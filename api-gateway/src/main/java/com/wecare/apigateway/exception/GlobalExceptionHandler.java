package com.wecare.apigateway.exception;

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
    public ResponseEntity<Error> authenticationException(AuthenticationException ex, WebRequest request){
        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND.toString(), Date.from(Instant.now()));
        return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
    }
}
