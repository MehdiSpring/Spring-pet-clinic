package com.springguru.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.PetType;
import com.springguru.service.PetTypeService;

@Service
@Profile({"default","map"})
public class PetTypeServiceMap extends AbstractMapService<Long, PetType> implements PetTypeService {

	@Override
	public PetType findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public void delete(PetType object) {
		// TODO Auto-generated method stub
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}
	
	
	
	

}
