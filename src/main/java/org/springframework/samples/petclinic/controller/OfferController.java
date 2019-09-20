package org.springframework.samples.petclinic.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.samples.petclinic.system.OrderNullException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping(value = "/saveOffer", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody void saveOffer( @RequestBody Offer newOffer) {
		offerService.createOffer(newOffer);

	}

	@RequestMapping(value = "/createOffer", method = RequestMethod.POST)
	public @ResponseBody Offer createOffer( @RequestBody Offer newOffer) {
		return offerService.createOffer(newOffer);

	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody List<Offer> findAll() {
		return offerService.findAll();
	}

	@RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
	public @ResponseBody Offer findOneById(@PathVariable Integer id) throws OrderNullException {
		return offerService.findById(id);
	}

	@RequestMapping(value = "/updateOffer", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateOffer( @RequestBody Offer offer) throws Exception {
		offerService.alterExpireDate(offer.getId(), offer.getExpireDate());
	}

	@RequestMapping(value = "/deleteOffer", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteOffer(@RequestBody Offer offer) throws OrderNullException {
		offerService.deleteOffer(offer.getId());
	}

	@RequestMapping(value = "/findActiveOffers", method = RequestMethod.GET)
	public @ResponseBody List<Offer> findByExpireDateGreaterThan() throws Exception {
		return offerService.findByExpireDateGreaterThan(new Date());
	}

}
