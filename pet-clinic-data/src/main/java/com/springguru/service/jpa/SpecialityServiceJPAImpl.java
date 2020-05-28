package com.springguru.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Speciality;
import com.springguru.repositories.SpecialityRepository;
import com.springguru.service.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityServiceJPAImpl implements SpecialityService {

	private final SpecialityRepository specialityRepository;
	
	public SpecialityServiceJPAImpl(SpecialityRepository specialityRepository) {
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return this.specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return this.specialityRepository.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		Set<Speciality> specialities = new HashSet<Speciality>();
		this.specialityRepository.findAll().forEach(specialities::add);
		
		return specialities;
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		this.specialityRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.specialityRepository.deleteById(id);

	}

}
