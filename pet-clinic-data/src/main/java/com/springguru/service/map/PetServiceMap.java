package com.springguru.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springguru.model.Pet;
import com.springguru.service.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Long, Pet> implements PetService {

	@Override
	public Pet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Pet> findAll() {
		
		return super.findAll();
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
