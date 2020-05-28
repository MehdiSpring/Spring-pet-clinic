package com.springguru.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springguru.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
