package org.springframework.samples.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService{
	
	
	@Autowired
	VisitRepository visitRepository;
	
	
	public void save(Visit visit) {
		this.visitRepository.save(visit);
	}
	
	
	public Visit findById(Integer id) {
		return visitRepository.findOne(id);
	}


	@Override
	public List<Visit> findAllByPetId(Integer petId) {
		return  visitRepository.findByPetId(petId);
	}


	@Override
	public List<Visit> findTop4OrderByDateDesc() {
		return visitRepository.findTop4ByOrderByDateDesc();
	}
	
	
}
