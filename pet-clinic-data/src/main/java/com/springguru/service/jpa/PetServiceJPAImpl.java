package com.springguru.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Pet;
import com.springguru.repositories.PetRepository;
import com.springguru.service.PetService;

@Service
@Profile("springdatajpa")
public class PetServiceJPAImpl implements PetService{

	private final PetRepository petRepository;
	
	public PetServiceJPAImpl(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return this.petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return this.petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		// TODO Auto-generated method stub
		Set<Pet> pets = new HashSet<Pet>();
		this.petRepository.findAll().forEach(pets::add);
		
		return pets;
	}

	@Override
	public void delete(Pet object) {
		// TODO Auto-generated method stub
		this.petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.petRepository.deleteById(id);
	}

}
