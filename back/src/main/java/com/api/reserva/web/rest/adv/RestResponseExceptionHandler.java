package com.api.reserva.web.rest.adv;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.reserva.services.exception.ServiceException;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ServiceException.class })
	protected ResponseEntity<ErrorMessage> serviceException(RuntimeException ex, WebRequest request) {

		ErrorMessage message = new ErrorMessage(ex.getMessage());

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);

	}

}
