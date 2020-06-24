package com.springguru.controllers;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.springguru.model.Owner;
import com.springguru.service.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController ownerControler;
	
	MockMvc mockMVC;
	
	Set<Owner> owners;
	
	@BeforeEach
	void setUp() throws Exception {
	    mockMVC = MockMvcBuilders.standaloneSetup(ownerControler).build();
	    owners = new HashSet<Owner>();
	    owners.add(new Owner());
	    owners.add(new Owner());
	}

	@Test
	void testListAllOwners() throws Exception{ 
		when(ownerService.findAll()).thenReturn(owners);
		mockMVC.perform(get("/owners")).andExpect(status().isOk())
		                               .andExpect(view().name("owners/index"))
		                               .andExpect(model().attribute("owners", Matchers.hasSize(2)));
	}

	@Test
	void testFindOwners() throws Exception{
		mockMVC.perform(get("/owners/find")).andExpect(status().isOk())
		                                    .andExpect(view().name("notImplemented"));
		verifyNoInteractions(ownerService);
		
	}

}
