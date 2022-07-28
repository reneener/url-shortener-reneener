package com.example.demo.presentation;

import com.example.demo.domain.exception.NewUrlNotFoundException;
import com.example.demo.domain.exception.UrlFormatException;
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

    @ExceptionHandler(UrlFormatException.class)
    public ResponseEntity handleFormatException(UrlFormatException e) {
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception e) {
        return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

};
