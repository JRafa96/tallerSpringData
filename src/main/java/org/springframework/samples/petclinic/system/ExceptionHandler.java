package org.springframework.samples.petclinic.system;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public final String handleException(Exception ex) {       
		return ex.getMessage();
    }
   
	
	
}
