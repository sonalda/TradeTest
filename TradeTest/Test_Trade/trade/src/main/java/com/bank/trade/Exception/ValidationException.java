package com.bank.trade.Exception;

import java.util.Map;

public class ValidationException extends RuntimeException {

	private Map<String, String> errorMap;
	
	public ValidationException(Map<String, String> errorMap)
	{
		super();
		this.errorMap = errorMap;
	}
	ValidationException()
	{
		super();
	}
	
}
