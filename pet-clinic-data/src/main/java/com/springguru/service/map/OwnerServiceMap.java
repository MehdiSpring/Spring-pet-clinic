package com.springguru.service.map;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.springguru.model.Owner;
import com.springguru.service.OwnerService;
import com.springguru.service.map.AbstractMapService;


@Service
public class OwnerServiceMap extends AbstractMapService<Long, Owner> implements OwnerService {

	@Override
	public Owner findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		
		return super.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		
		return super.findAll();
	}

	@Override
	public void delete(Owner object) {
        super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

	@Override
	public Owner findByLastname(String name) {
		
		for(Map.Entry<Long,Owner> mapEntry: this.abstractMap.entrySet())
		{
			if(mapEntry.getValue().getLastName().equals(name))
				return mapEntry.getValue();
		}
		
		return null;
	}

}
