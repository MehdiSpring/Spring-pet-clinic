package com.springguru.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<ID,T> {
	
	protected Map<ID, T> abstractMap = new HashMap<>();
	
	public T findById(ID id)
	{
		return this.abstractMap.get(id);
	}
	
	public T save(ID id, T object)
	{
		this.abstractMap.put(id, object);
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
