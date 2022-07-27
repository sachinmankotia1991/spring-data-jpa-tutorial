package com.sachin.demo.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DefaultExcpetionHandler {

	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<ErrorDetails> handleNoDataFoundExecption(NoDataFoundException exception,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("APP_ERR_1", new Date(), exception.getMessage());
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);

	}

}
