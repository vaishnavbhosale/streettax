package com.streettax.streettax.exception;

public class BusinessException extends RuntimeException{

    public final String error;

    public BusinessException(String error, String message){
        super(message);
        this.error = error;

    }
    public String getError(){
        return error;
    }
}
