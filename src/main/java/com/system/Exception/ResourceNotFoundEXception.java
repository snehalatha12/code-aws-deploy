package com.system.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundEXception extends Exception{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundEXception(String message) {
		super(message);
	}
}
