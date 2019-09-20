package org.springframework.samples.petclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.system.DateInvalidException;
import org.springframework.samples.petclinic.system.OrderNullException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler{

	
	 @ExceptionHandler(OrderNullException.class)
	 public final ResponseEntity<String> OrderNullExceptionControll() {
		 return new ResponseEntity<String>("Oferta não existe", HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 @ExceptionHandler(DateInvalidException.class)
	 public final ResponseEntity<String> DateInvalidExceptionControll() {
		 return new ResponseEntity<String>("Formato de data inválido", HttpStatus.NOT_ACCEPTABLE);
	 }
	 
	 
	 
	
}
