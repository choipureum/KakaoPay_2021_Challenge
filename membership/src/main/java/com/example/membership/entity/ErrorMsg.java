package com.example.membership.entity;

import lombok.Data;

@Data
public class ErrorMsg{
    private String message;  
    private int response;
    
    public ErrorMsg()
    {
        this.message = "membership_id must be provided";
        this.response = 400;
    }

    public ErrorMsg(String message,int response)
    {
        this.message = message;
        this.response = response;
    }
}