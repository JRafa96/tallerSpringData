package org.springframework.samples.petclinic.system;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public final String handleException(Exception ex) {  
		if(ex instanceof IOException) {
			//faz algo
		} else if (ex instanceof NullPointerException) {
			//faz algo
		} //...etc
		return ex.getMessage();
    }
   
	
	
}
