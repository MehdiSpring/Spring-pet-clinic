package com.springguru.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.springguru.model.BaseEntity;

public abstract class AbstractMapService<ID,T extends BaseEntity> {
	
	protected Map<Long, T> abstractMap = new HashMap<>();
	
	public T findById(ID id)
	{
		return this.abstractMap.get(id);
	}
	
	public T save(T object)
	{
		Long nextId =null;
		
		if(object == null)
		{
			throw new NullPointerException(" #Exception# the oject is null !!!!");
		}
		
		try {
				nextId = Collections.max(abstractMap.keySet()) + 1;
		}catch(NoSuchElementException e) {
			nextId = 5L;
		}
		
		
		object.setId(nextId);
		
		this.abstractMap.put(object.getId(), object);
		return object;
	}
	
	public Set<T> findAll()
	{
		Set<T> values = new HashSet<>(this.abstractMap.values());
		return values;
	}
	
	public void deleteById(ID id)
	{
		this.abstractMap.remove(id);
	}
	
	public void delete(T object)
	{
		this.abstractMap.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}

}
