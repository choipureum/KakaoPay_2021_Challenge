package com.example.membership.exceptionHandler;

import com.example.membership.entity.Message;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseStatusExceptionResolver extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handlerException(Exception ex, WebRequest request) 
    {
        Message msg = new Message();     
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex,msg, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}