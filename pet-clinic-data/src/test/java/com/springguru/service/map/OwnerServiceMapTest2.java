package com.springguru.service.map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.springguru.model.Owner;

public class OwnerServiceMapTest2 {

	OwnerServiceMap ownerServiceMap;
	@Before
	public void setUp() throws Exception {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap());
		
		ownerServiceMap.save(new Owner().builder().lastName("BOUMZZI").build());
	}

	@Test
	public void FindByIdLong() {
		Owner owner = ownerServiceMap.findById(5L);
		assertNotNull(owner);
		assertEquals(5L, owner.getId());
	}

	@Test
	public void SaveOwner() {
		Owner owner2 = ownerServiceMap.save(new Owner());
		assertNotNull(owner2);
		assertEquals(2, ownerServiceMap.findAll().size());
	}

	@Test
	public void FindAll() {
		assertEquals(1, ownerServiceMap.findAll().size());
	}

	@Test
	public void DeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(5L));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void DeleteByIdLong() {
		ownerServiceMap.deleteById(5L);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	public void FindByLastname() {
		Owner owner = ownerServiceMap.findByLastname("BOUMZZI");
		assertNotNull(owner);
		assertEquals("BOUMZZI", owner.getLastName());
	}

}
