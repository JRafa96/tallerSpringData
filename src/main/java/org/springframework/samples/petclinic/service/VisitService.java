package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Visit;

public interface VisitService {
	
	void save(Visit visit);
	
	Visit findById(Integer id);
	
	List<Visit> findAllByPetId(Integer petId);
	
	
	
	List<Visit> findTop4OrderByDateDesc();
	
	
}
