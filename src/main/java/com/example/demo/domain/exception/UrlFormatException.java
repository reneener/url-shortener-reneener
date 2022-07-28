package com.example.demo.domain.exception;

public class UrlFormatException extends RuntimeException{
    public UrlFormatException(){

    }
    public UrlFormatException(String message){
        super(message);
    }
}
