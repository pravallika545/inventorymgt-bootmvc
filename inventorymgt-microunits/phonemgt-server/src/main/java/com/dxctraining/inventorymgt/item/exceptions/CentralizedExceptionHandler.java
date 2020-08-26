package com.dxctraining.inventorymgt.item.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(ItemNullException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleComputerNotfoundException(ItemNullException e){
        String msg = e.getMessage();
        return msg;
    }
    @ExceptionHandler(InvalidItemArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidArgumentException(InvalidItemArgumentException e){
        String msg = e.getMessage();
        return msg;
    }
}
