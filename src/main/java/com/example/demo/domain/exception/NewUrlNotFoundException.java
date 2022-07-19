package com.example.demo.domain.exception;

public class NewUrlNotFoundException extends RuntimeException {

    public NewUrlNotFoundException(){
    }

    public NewUrlNotFoundException(String message){
        super(message);
    }
};
