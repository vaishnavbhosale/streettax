package com.streettax.streettax.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private String error;
    private String path;

    public ErrorResponse(LocalDateTime timestamp, String message,
                           int status, String error, String path){
        this.error = error;
        this.message = message;
        this.path = path;
        this. status = status;
        this.timestamp = timestamp;

    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    public String getMessage(){
        return message;
    }
    public int getStatus(){
        return status;
    }
    public String getError() {
        return error;
    }
    public String getPath(){
        return path;
    }
}
