package com.springguru.service;

import java.util.Set;

import com.springguru.model.Owner;

public interface OwnerService {
	
	Owner findByLastname(String name);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();

}
