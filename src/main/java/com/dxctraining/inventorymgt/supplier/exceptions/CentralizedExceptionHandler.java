package com.dxctraining.inventorymgt.supplier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ExceptionHandler(SupplierNullException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleSupplierNotFound(SupplierNullException e) {
		String msg = e.getMessage();
		return msg;
	}
	
	@ExceptionHandler(InvalidSupplierArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidSupplier(InvalidSupplierArgumentException e) {
		String msg = e.getMessage();
		return msg;
	}

}
