package org.springframework.samples.petclinic.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.samples.petclinic.service.BillService;
import org.springframework.stereotype.Service;


/**
 * The Class BillServiceImpl.
 */
@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillRepository billRepository;
	
	/**
	 * Save.
	 *
	 * @param bill the bill
	 */
	public void save(Bill bill) {
		billRepository.save(bill);
	}
	
	public Bill createBill(Bill bill) {
		return billRepository.save(bill);
		
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the bill
	 */
	public Bill findById(Integer id) {
		return billRepository.findOne(id);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Bill> findAll() {
		return billRepository.findAll();
	}

	public void alterDate(Integer id,Date date) {
		Bill bill = billRepository.findOne(id);
		bill.setPaymentDate(date);
		billRepository.save(bill);
	}
	
	public void deleteBill(Integer id) {
		billRepository.delete(id);
	}

	
	public List<Bill> findByMoneyGreaterThan(Double money) {
		return billRepository.findByMoneyGreaterThan(money);
		
	}
	
	public List<Bill> findByMoneyLessThan(Double money) {
		return billRepository.findByMoneyLessThan(money);
		
	}
	
	
	public Long countBills() {
		return billRepository.count();
	}
	
	
	
}
