package com.springguru.service;

import java.util.Set;

import com.springguru.model.Pet;

public interface PetService {

    Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
