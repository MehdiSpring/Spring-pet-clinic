package com.springguru.service;
 
import java.util.List;

import com.springguru.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastname(String name);
	
	List<Owner> findAllByLastNameLike(String lastName);

}
