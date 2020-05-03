package com.springguru.service;

import com.springguru.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	
	Owner findByLastname(String name);

}
