package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Bill;

// TODO: Auto-generated Javadoc
/**
 * The Interface BillService.
 */
public interface BillService {
	
	
	
	/**
	 * Save.
	 *
	 * @param bill the bill
	 * @return 
	 */
	void save(Bill bill);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the bill
	 */
	Bill findById(Integer id);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Bill> findAll();
	
	Bill createBill(Bill bill);
	 
	void alterDate(Integer id, Date date);
	
	void deleteBill(Integer id);
	
	List<Bill> findByMoneyGreaterThan (Double money);
	List<Bill> findByMoneyLessThan (Double money);
	
	Long countBills();
	
	
}
