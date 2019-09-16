package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.Owner;

public interface OwnerService {

	void save(Owner owner);

	Owner findById(Integer id);
	
	
	

}
