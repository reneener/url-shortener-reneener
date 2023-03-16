package com.example.demo.presentation.exception;

public class AlreadyExistShortenUrlException extends RuntimeException{
    public AlreadyExistShortenUrlException(){

    }
    public AlreadyExistShortenUrlException(String message){
        super(message);
    }
}
