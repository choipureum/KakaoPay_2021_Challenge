package com.example.membership.entity;

import lombok.Data;


@Data
public class Message {
    private boolean success;  
    private Object response;
    private ErrorMsg error;   

    public Message() {
        this.success = false;
        this.error = new ErrorMsg("X-USER-ID",400);
        this.response = null;
    }
    public enum StatusEnum {

        OK(200, "OK"),
        BAD_REQUEST(400, "BAD_REQUEST"),
        NOT_FOUND(404, "NOT_FOUND"),
        INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");
    
        int statusCode;
        String code;      
    
        StatusEnum(int statusCode, String code) {
            this.statusCode = statusCode;                     
            this.code = code;
        }
    } 
}
