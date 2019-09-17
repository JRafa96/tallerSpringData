package org.springframework.samples.petclinic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.service.BillService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(value="/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	

	@ValidateOnExecution
	@RequestMapping(value="/createBill", method = RequestMethod.POST)
	public Bill createBill(@Valid @RequestBody Bill newBill) {
		System.out.println("##Create new bill, id --> ##" + newBill.getId());
		return billService.createBill(newBill);
		
	};
	
	@RequestMapping(value="/bills", method = RequestMethod.GET)
	public List<Bill> findAll(){
		return this.billService.findAll();
	}
	
	@RequestMapping(value="/bills/{idBill}", method = RequestMethod.GET)
	public Bill findById(@PathVariable ("idBill") Integer id) {
		return this.billService.findById(id);
	}
	
	
	
	@RequestMapping(value="/alterBill", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void alterDate(@RequestBody Bill bill) {
		this.billService.alterDate(bill.getId(), bill.getPaymentDate());
	}
	
	@RequestMapping(value="/deleteBill", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBill(@RequestBody Bill bill) {
		this.billService.deleteBill(bill.getId());
	}
	
	
	@RequestMapping(value="/billsGreaterThan/{money}", method = RequestMethod.GET)
	public List<Bill> findByMoneyGreaterThan (@PathVariable ("money")Double money) {
		return this.billService.findByMoneyGreaterThan(money);
	}
	
	@RequestMapping(value="/billsLessThan/{money}", method = RequestMethod.GET)
	public List<Bill> findByMoneyLessThan (@PathVariable ("money")Double money) {
		return this.billService.findByMoneyLessThan(money);
	}
	
	
	@RequestMapping(value="/countBills", method = RequestMethod.GET)
	public Long countBills(){
		return this.billService.countBills();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, HttpServletRequest request) {
		return "Exception ----> " + ex.getMessage();
	}
	
}
