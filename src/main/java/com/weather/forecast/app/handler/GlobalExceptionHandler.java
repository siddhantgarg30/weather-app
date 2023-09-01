package com.weather.forecast.app.handler;

import com.weather.forecast.app.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException badCredentialsException) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorMessage(badCredentialsException.getMessage()).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {DisabledException.class})
    public ResponseEntity<ErrorResponse> handleDisabledException(DisabledException disabledException) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorMessage(disabledException.getMessage()).build(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorMessage(exception.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

