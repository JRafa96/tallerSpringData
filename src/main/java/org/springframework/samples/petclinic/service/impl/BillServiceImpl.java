package org.springframework.samples.petclinic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.samples.petclinic.service.BillService;
import org.springframework.stereotype.Service;


@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillRepository billRepository;
	
	public void save(Bill bill) {
		billRepository.save(bill);
	}

	public Bill findById(Integer id) {
		return billRepository.findOne(id);
	}

	
	
	
}
