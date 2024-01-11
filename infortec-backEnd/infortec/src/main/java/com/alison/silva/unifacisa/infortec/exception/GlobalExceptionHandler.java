package com.alison.silva.unifacisa.infortec.exception;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alison.silva.unifacisa.infortec.services.exceptions.DataBindingViolationException;
import com.alison.silva.unifacisa.infortec.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler implements AuthenticationFailureHandler {

	@Value("${serve.error.include-exception}")
	private boolean printStackTrace;
	
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Validation error. Check 'errors' field for details.");

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.unprocessableEntity().body(errorResponse);

	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		Integer status = HttpStatus.UNAUTHORIZED.value();
		response.setStatus(status);
		response.setContentType("application/json");
		ErrorResponse errorResponse = new ErrorResponse(status, "Username or password are invalid");
		response.getWriter().append(errorResponse.toJson());

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {
		final String errorMessage = "Unknown error occurred";

		return buildErrorResponse(exception, errorMessage, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<Object> handleDataIntegrityViolationException(
			DataIntegrityViolationException dataIntegrityViolationException, WebRequest request) {
		String errorMessage = dataIntegrityViolationException.getMostSpecificCause().getMessage();

		return buildErrorResponse(dataIntegrityViolationException, errorMessage, HttpStatus.CONFLICT, request);

	}

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException objectNotFoundException,
			WebRequest request) {

		return buildErrorResponse(objectNotFoundException, HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<Object> handleAuthenticationException(AuthenticationException authenticationException,
			WebRequest request) {
		return buildErrorResponse(authenticationException, HttpStatus.UNAUTHORIZED, request);
	}

	@ExceptionHandler(DataBindingViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<Object> handleDataBindingViolationException(
			DataBindingViolationException dataBindingViolationException, WebRequest request) {

		return buildErrorResponse(dataBindingViolationException, HttpStatus.CONFLICT, request);
	}

	private ResponseEntity<Object> buildErrorResponse(Exception exception, HttpStatus httpStatus, WebRequest request) {
		return buildErrorResponse(exception, exception.getMessage(), httpStatus, request);
	}

	private ResponseEntity<Object> buildErrorResponse(Exception exception, String message, HttpStatus httpStatus,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);

		if (this.printStackTrace) {
			errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
		}

		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
