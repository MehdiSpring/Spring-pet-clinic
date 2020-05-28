package com.springguru.service.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Vet;
import com.springguru.repositories.VetRepository;
import com.springguru.service.VetService;

@Service
@Profile("springdatajpa")
public class VetServiceJPAImpl implements VetService {

	private final VetRepository vetRepository;
	
	public VetServiceJPAImpl(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		// TODO Auto-generated method stub
		
		return this.vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return this.vetRepository.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		// TODO Auto-generated method stub
		Set<Vet> vets = new HashSet<Vet>();
		this.vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		this.vetRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.vetRepository.deleteById(id);

	}

}
