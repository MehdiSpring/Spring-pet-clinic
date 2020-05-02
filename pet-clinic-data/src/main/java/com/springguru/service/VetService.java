package com.springguru.service;

import java.util.Set;

import com.springguru.model.Vet;

public interface VetService {
	
    Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();

}
