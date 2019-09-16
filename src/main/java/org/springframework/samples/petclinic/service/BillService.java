package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.Bill;

public interface BillService {
	
	void save(Bill bill);
	
	Bill findById(Integer id);
	
	
	
}
