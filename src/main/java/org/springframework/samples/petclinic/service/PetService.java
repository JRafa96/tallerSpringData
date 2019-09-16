package org.springframework.samples.petclinic.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

public interface PetService {
	
	
	void save(Pet pet);
	
	Pet findById(Integer id);
	

	List<Pet> findByBirthDateBetweenOrderByBirthDateAsc(Date date1, Date date2);
	
	//List<PetType> findPetTypes();
}
