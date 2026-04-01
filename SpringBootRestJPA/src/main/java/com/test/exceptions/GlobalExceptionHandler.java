package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=ProductNotFoundExceptions.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorMessage> productNotFoundException(ProductNotFoundExceptions e , WebRequest request)
	{
		int code = HttpStatus.NOT_FOUND.value();
		ErrorMessage message = new ErrorMessage();
		message.setTimestamp(new Date());
		message.setMessage(e.getMessage());
		message.setUrl(request.getDescription(false));
		message.setStatusCode(code);
		
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorMessage> unKnownException(ProductNotFoundExceptions e , WebRequest request)
	{
		int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
		ErrorMessage message = new ErrorMessage();
		message.setTimestamp(new Date());
		message.setMessage(e.getMessage());
		message.setUrl(request.getDescription(false));
		message.setStatusCode(code);
		
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
