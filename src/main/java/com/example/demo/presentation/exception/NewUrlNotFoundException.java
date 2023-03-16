package com.example.demo.presentation.exception;

public class NewUrlNotFoundException extends RuntimeException {

    public NewUrlNotFoundException(){
    }

    public NewUrlNotFoundException(String message){
        super(message);
    }
};
