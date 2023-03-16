package com.example.demo.presentation;

import com.example.demo.presentation.exception.AlreadyExistShortenUrlException;
import com.example.demo.presentation.exception.ManyDuplicationException;
import com.example.demo.presentation.exception.NewUrlNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NewUrlNotFoundException.class)
    public ResponseEntity handleNotFoundException(NewUrlNotFoundException e) {
        log.error("Error occurs {}", e.toString());
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ManyDuplicationException.class)
    public ResponseEntity handleTimeoutException(ManyDuplicationException e) {
        log.error("Error occurs {}", e.toString());
        return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(AlreadyExistShortenUrlException.class)
    public ResponseEntity handleFormatException(AlreadyExistShortenUrlException e) {
        log.error("Error occurs {}", e.toString());
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(Exception e) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

};
