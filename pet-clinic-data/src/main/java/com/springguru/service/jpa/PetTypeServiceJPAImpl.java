package com.springguru.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


import com.springguru.model.PetType;
import com.springguru.repositories.PetTypeRepository;
import com.springguru.service.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeServiceJPAImpl implements PetTypeService {

	private final PetTypeRepository petTypeRepository;
	
	public PetTypeServiceJPAImpl(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return this.petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return this.petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		Set<PetType> petTypes = new HashSet<PetType>();
		this.petTypeRepository.findAll().forEach(petTypes::add);
		
		return petTypes;
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		this.petTypeRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.petTypeRepository.deleteById(id);

	}

}
