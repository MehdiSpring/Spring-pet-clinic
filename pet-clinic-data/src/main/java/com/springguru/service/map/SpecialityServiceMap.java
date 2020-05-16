package com.springguru.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springguru.model.Speciality;
import com.springguru.service.SpecialityService;

@Service
public class SpecialityServiceMap extends AbstractMapService<Long, Speciality> implements SpecialityService {

	@Override
	public Speciality findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public void delete(Speciality object) {
		// TODO Auto-generated method stub
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
        super.deleteById(id);
	}

}
