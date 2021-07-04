package com.example.membership.exceptionHandler;

import com.example.membership.entity.ErrorMsg;
import com.example.membership.entity.Message;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.BadGateway;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseStatusExceptionResolver extends ResponseEntityExceptionHandler 
{
    @ExceptionHandler(value = NullPointerException.class)
    protected ResponseEntity<Object> handlerException(NullPointerException ex, WebRequest request) 
    {
        Message msg = new Message();  
        msg.setError(new ErrorMsg(ex.getMessage(),400));    
        HttpHeaders headers = new HttpHeaders();       
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex,msg, headers, HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = ServerErrorException.class)
    protected ResponseEntity<Object> handlerException(ServerErrorException ex, WebRequest request) 
    {
        Message msg = new Message();     
        msg.setError(new ErrorMsg(ex.getMessage(),500)); 
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex,msg, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = BadRequest.class)
    protected ResponseEntity<Object> handlerException(BadRequest ex, WebRequest request) 
    {
        Message msg = new Message();    
        msg.setError(new ErrorMsg(ex.getMessage(),405));  
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex,msg, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = BadGateway.class)
    protected ResponseEntity<Object> handlerException(BadGateway ex, WebRequest request) 
    {
        Message msg = new Message();
        msg.setError(new ErrorMsg(ex.getMessage(),500));     
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex,msg, headers, HttpStatus.BAD_GATEWAY, request);
    }
}