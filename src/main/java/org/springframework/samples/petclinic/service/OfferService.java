package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.system.DateInvalidException;
import org.springframework.samples.petclinic.system.OrderNullException;

public interface OfferService {

	void saveOffer(Offer offer);
	
	Offer createOffer(Offer offer);
	
	Offer findById(Integer id) throws OrderNullException ;
	
	List<Offer> findAll();
	
	void alterExpireDate(Integer id, Date expireDate) throws Exception;
	
	void deleteOffer(Integer id) throws OrderNullException;
	
	List<Offer> findByExpireDateGreaterThan(Date date) throws Exception;
	
	
}
