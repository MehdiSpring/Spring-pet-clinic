package com.springguru.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springguru.model.Vet;
import com.springguru.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Long, Vet> implements VetService {

	@Override
	public Vet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		
		return super.save(object.getId(), object);
	}

	@Override
	public Set<Vet> findAll() {
		
		return super.findAll();
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
