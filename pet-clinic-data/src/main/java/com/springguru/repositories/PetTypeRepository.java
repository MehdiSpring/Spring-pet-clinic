package com.springguru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springguru.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long>{

}
