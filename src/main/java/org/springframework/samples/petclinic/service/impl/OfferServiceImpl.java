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

// TODO: Auto-generated Javadoc
/**
 * The Class OfferServiceImpl.
 */
@Service
public class OfferServiceImpl implements OfferService {

	/** The offer repository. */
	@Autowired
	OfferRepository offerRepository;

	/**
	 * Save offer.
	 *
	 * @param offer the offer
	 */
	public void saveOffer(Offer offer) {
		offerRepository.save(offer);
	}

	/**
	 * Creates the offer.
	 *
	 * @param offer the offer
	 * @return the offer
	 */
	public Offer createOffer(Offer offer) {

		return offerRepository.save(offer);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the offer
	 * @throws OrderNullException the order null exception
	 */
	public Offer findById(Integer id) throws OrderNullException {
		if (offerRepository.findOne(id) == null) {
			throw new OrderNullException();
		} else
			return offerRepository.findOne(id);

	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	/**
	 * Alter expire date.
	 *
	 * @param id   the id
	 * @param date the date
	 * @throws Exception the exception
	 */
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

	/**
	 * Delete offer.
	 *
	 * @param id the id
	 * @throws OrderNullException the order null exception
	 */
	public void deleteOffer(Integer id) throws OrderNullException {
		if (offerRepository.findOne(id) == null) {
			throw new OrderNullException();
		} else {
			offerRepository.delete(id);
		}

	}

	/**
	 * Find by expire date greater than.
	 *
	 * @param date the date
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Offer> findByExpireDateGreaterThan(Date date) throws Exception {
		if (!(date instanceof Date)) {
			throw new DateInvalidException();
		} else
			return offerRepository.findByExpireDateGreaterThan(date);
	}

	/**
	 * Instantiates a new offer service impl.
	 */
	public OfferServiceImpl() {

	}

}
