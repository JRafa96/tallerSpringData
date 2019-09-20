package org.springframework.samples.petclinic.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService{
	
	@Autowired
	OfferRepository offerRepository;

	public void saveOffer(Offer offer) {
		offerRepository.save(offer);
	}

	public Offer createOffer(Offer offer) {
		return offerRepository.save(offer);
	}

	public Offer findById(Integer id) {
		return offerRepository.findOne(id);
	}

	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	public void alterExpireDate(Integer id, Date date) {
		Offer offer = offerRepository.findOne(id);
		offer.setExpireDate(date);
		offerRepository.save(offer);
		
	}

	public void deleteOffer(Integer id) {
		offerRepository.delete(id);
		
	}

	
	public List<Offer> findByExpireDateGreaterThan(Date date) {
		return offerRepository.findByExpireDateGreaterThan(date);
	}

	public OfferServiceImpl() {
		
	}

	
	
	
	
	

}
