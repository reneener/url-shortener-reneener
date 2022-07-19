package com.example.demo.presentation;

import com.example.demo.domain.exception.NewUrlNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NewUrlNotFoundException.class)
    public ResponseEntity handleNotFoundException(NewUrlNotFoundException e) {
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception e) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

};
