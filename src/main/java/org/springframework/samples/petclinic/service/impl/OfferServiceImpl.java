package org.springframework.samples.petclinic.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.samples.petclinic.system.DateInvalidException;
import org.springframework.samples.petclinic.system.OrderNullException;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferRepository offerRepository;

	public void saveOffer(Offer offer) {
		offerRepository.save(offer);
	}

	public Offer createOffer(Offer offer) {

		return offerRepository.save(offer);
	}

	public Offer findById(Integer id) throws OrderNullException {
		if (offerRepository.findOne(id) == null) {
			throw new OrderNullException();
		} else
			return offerRepository.findOne(id);

	}

	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	public void alterExpireDate(Integer id, Date date) throws Exception {
		Offer offer = offerRepository.findOne(id);
		if (offer == null) {
			throw new OrderNullException();
		} else if (!(date instanceof Date)) {
			throw new DateInvalidException();
		} else {
			offer.setExpireDate(date);
			offerRepository.save(offer);
		}

	}

	public void deleteOffer(Integer id) throws OrderNullException {
		if (offerRepository.findOne(id) == null) {
			throw new OrderNullException();
		} else {
			offerRepository.delete(id);
		}

	}

	public List<Offer> findByExpireDateGreaterThan(Date date) throws Exception {
		if (!(date instanceof Date)) {
			throw new DateInvalidException();
		} else
			return offerRepository.findByExpireDateGreaterThan(date);
	}

	public OfferServiceImpl() {

	}

}
