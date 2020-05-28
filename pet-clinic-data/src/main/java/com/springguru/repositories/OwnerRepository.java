package com.springguru.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springguru.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{

	Optional<Owner> findByLastName(String lastName);
}
