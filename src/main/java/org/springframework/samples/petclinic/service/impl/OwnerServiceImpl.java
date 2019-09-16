package org.springframework.samples.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceImpl implements OwnerService{

	
	@Autowired
	OwnerRepository ownerRepository;
	
	public void save(Owner owner) {
		ownerRepository.save(owner);
		
	}

	public Owner findById(Integer id) {
		return ownerRepository.findById(id);
	}
	
	
	 
    public List<Owner> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName){
    	return ownerRepository.findByFirstNameContainingOrLastNameContaining(firstName, lastName);
    };
    
    
   
    public List<Owner> searchOwner(String query){
    	return ownerRepository.searchOwner(query);
    };
    
    public List<Owner> findByOrderByLastName(){
    	return ownerRepository.findByOrderByLastName();
    };
	
	
	
}
