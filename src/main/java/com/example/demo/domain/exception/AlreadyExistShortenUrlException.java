package com.example.demo.domain.exception;

public class AlreadyExistShortenUrlException extends RuntimeException{
    public AlreadyExistShortenUrlException(){

    }
    public AlreadyExistShortenUrlException(String message){
        super(message);
    }
}
