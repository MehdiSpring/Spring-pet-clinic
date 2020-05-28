package com.springguru.service.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springguru.model.Visit;
import com.springguru.service.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Long, Visit> implements VisitService {

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

}
