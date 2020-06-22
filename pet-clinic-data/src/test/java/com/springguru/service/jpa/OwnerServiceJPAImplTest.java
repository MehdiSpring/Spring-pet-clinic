package com.springguru.service.jpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springguru.model.Owner;
import com.springguru.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPAImplTest {

	@Mock
	OwnerRepository ownerRepository;
	
	//This annotation allows to instantiate our object by injecting the mock objects
	@InjectMocks
	OwnerServiceJPAImpl ownerServiceJpa;
	
	Owner returnedOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		returnedOwner = new Owner().builder().lastName("BOUMZZI").build();
	}

	@Test
	void testFindById() {
		
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
		Owner owner = ownerServiceJpa.findById(1L);
		assertNotNull(owner);
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnedOwner);
		Owner owner = ownerServiceJpa.save(new Owner().builder().lastName("BOUMZZI").build());
		assertNotNull(owner);
	}

	@Test
	void testFindAll() {
		Set<Owner> setOfOwners = new HashSet<Owner>();
		setOfOwners.add(new Owner());
		setOfOwners.add(new Owner());
		when(ownerRepository.findAll()).thenReturn(setOfOwners);
		Set<Owner> owners = ownerServiceJpa.findAll(); 
		assertEquals(2, owners.size());
	}

	@Test
	void testDelete() {
		ownerServiceJpa.delete(returnedOwner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerServiceJpa.deleteById(1L);
		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastname() {
		when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(returnedOwner));
		Owner owner = ownerServiceJpa.findByLastname("BOUMZZI");
		assertNotNull(owner);
		assertEquals("BOUMZZI", owner.getLastName());
	}

}
