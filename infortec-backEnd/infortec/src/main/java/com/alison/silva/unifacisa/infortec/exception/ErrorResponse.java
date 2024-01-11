package com.alison.silva.unifacisa.infortec.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
	private final int status;
	private final String message;
	private String stackTrace;
	private List<ValidationError> erros;
	
	
	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public List<ValidationError> getErros() {
		return erros;
	}

	public void setErros(List<ValidationError> erros) {
		this.erros = erros;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	private static class ValidationError {
		private final String field;
		private final String message;
		
		public ValidationError(String field, String message) {
			this.field = field;
			this.message = message;
		}

		public String getField() {
			return field;
		}

		public String getMessage() {
			return message;
		}
		
	}
	
	public void addValidationError(String filed, String message) {
		if(Objects.isNull(erros)) {
			this.erros = new ArrayList<>();
		}
		
		this.erros.add(new ValidationError(filed, message));
	}
	
	public String toJson() {
		return "{\"status\": " + getStatus() + ", " + 
		"\"message\": \"" + getMessage() + "\"}";
	}
	
}
