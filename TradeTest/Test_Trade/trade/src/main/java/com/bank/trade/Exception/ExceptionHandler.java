package com.bank.trade.Exception;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ValidationException.class)
	public  EntityResponse validationException(Map<String, String> errorMap) {
		
		return null;
		// TODO Auto-generated method stub

	}

}
