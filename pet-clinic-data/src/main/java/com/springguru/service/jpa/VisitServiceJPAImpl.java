package com.springguru.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Visit;
import com.springguru.repositories.VisitRepository;
import com.springguru.service.VisitService;

@Service
@Profile("springdatajpa")
public class VisitServiceJPAImpl implements VisitService {

	private final VisitRepository visitRepository;
	
	public VisitServiceJPAImpl(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return this.visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return this.visitRepository.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		Set<Visit> visits = new HashSet<Visit>();
		this.visitRepository.findAll().forEach(visits::add);
		
		return visits;
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		this.visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.visitRepository.deleteById(id);
	}

}
