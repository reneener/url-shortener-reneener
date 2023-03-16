package com.example.demo.presentation.exception;

public class ManyDuplicationException extends RuntimeException{
    public ManyDuplicationException(){

    }
    public ManyDuplicationException(String message){
        super(message);
    }
};
