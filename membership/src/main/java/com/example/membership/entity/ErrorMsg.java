package com.example.membership.entity;

import lombok.Data;

@Data
public class ErrorMsg{

    private String message;  
    private int response;
    
    public ErrorMsg(String message)
    {
        this.message = message;
        this.response = 400;
    }

    public ErrorMsg(String message,int response)
    {
        this.message = message+" must be provided";
        this.response = response;
    }
}