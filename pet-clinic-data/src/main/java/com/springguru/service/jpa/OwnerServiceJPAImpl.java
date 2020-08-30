package com.springguru.service.jpa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Owner;
import com.springguru.repositories.OwnerRepository;
import com.springguru.service.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerServiceJPAImpl implements OwnerService {

	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJPAImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findById(Long id) {
		
		//SInce Spring 5, this is returning an Optional type
		Optional<Owner> owner = this.ownerRepository.findById(id);
		
		if(owner.isPresent())
			return owner.get();
		else
			return null;
	}

	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return this.ownerRepository.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		// TODO Auto-generated method stub
	    Set<Owner> setOwners = new HashSet<Owner>();
	    
	    /*Iterator<Owner> owners= this.ownerRepository.findAll().iterator();
	    
	    while(owners.hasNext())
	    {
	    	setOwners.add(owners.next());
	    }
	    
	    return setOwners;*/
	    
	    //This is a new way to use the lampbda expression
	    this.ownerRepository.findAll().forEach(setOwners::add);
	    
	    return setOwners;
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub

		this.ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastname(String name) {
		// TODO Auto-generated method stub
		Optional<Owner> owner = this.ownerRepository.findByLastName(name);
		
		if(owner.isPresent())
			return owner.get();
		else
			return null;
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		// TODO Auto-generated method stub
		return this.ownerRepository.findAllByLastNameLike("%"+lastName+"%");
	}

}
