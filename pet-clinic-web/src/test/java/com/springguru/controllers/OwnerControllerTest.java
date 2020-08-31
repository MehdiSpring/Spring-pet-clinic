package com.springguru.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
		                                    .andExpect(view().name("owners/findOwners"));
		verifyNoInteractions(ownerService);
		
	}
	
	@Test
	void testFindOwnerByLastNameNoOwner() throws Exception{
		List<Owner> ownersList = new ArrayList<Owner>();
		when(ownerService.findAllByLastNameLike(ArgumentMatchers.anyString())).thenReturn(ownersList);
		
		mockMVC.perform(get("/owners/lastName")).andExpect(status().isOk())
												.andExpect(view().name("owners/findOwners"));
																								
	}
	
	@Test
	void testFindOwnerByLastNameOneOwner() throws Exception{
		List<Owner> ownersList = new ArrayList<Owner>();
		Owner owner= new Owner();
		owner.setId(1L);
		ownersList.add(owner);
		
		when(ownerService.findAllByLastNameLike(ArgumentMatchers.anyString())).thenReturn(ownersList);
		
		mockMVC.perform(get("/owners/lastName")).andExpect(status().is3xxRedirection())
												.andExpect(view().name("redirect:/owners/"+owner.getId()));
																								
	}
	
	@Test
	void testFindOwnerByLastNameManyOwners() throws Exception{
		List<Owner> ownersList = new ArrayList<Owner>();
		ownersList.add(new Owner());
		ownersList.add(new Owner());
		
		when(ownerService.findAllByLastNameLike(ArgumentMatchers.anyString())).thenReturn(ownersList);
		
		mockMVC.perform(get("/owners/lastName")).andExpect(status().isOk())
												.andExpect(model().attributeExists("owners"))
												.andExpect(view().name("owners/ownersList"));
																								
	}
	
	@Test
	void testShowOwner() throws Exception{
		Owner owner = new Owner();
		owner.setId(1L);
		
		when(ownerService.findById(ArgumentMatchers.anyLong())).thenReturn(owner);
		
		mockMVC.perform(get("/owners/1")).andExpect(status().isOk())
										 .andExpect(model().attribute("owner",Matchers.hasProperty("id", is(1L))));
	}
	
	@Test
	void testGoToCreateTemplate() throws Exception{
		mockMVC.perform(get("/owners/new")).andExpect(status().isOk())
										   .andExpect(view().name("owners/createOrUpdateOwnerForm"))
										   .andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void testCreateOwner() throws Exception{
		Owner owner = new Owner();
		owner.setId(1L);
		
		when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);
		
		mockMVC.perform(post("/owners/new")).andExpect(status().is3xxRedirection())
											.andExpect(view().name("redirect:/owners/1"));
	}
	
	@Test
	void testGoToUpdateTemplate() throws Exception{
		when(ownerService.findById(ArgumentMatchers.anyLong())).thenReturn(new Owner());
		
		mockMVC.perform(get("/owners/1/edit")).andExpect(status().isOk())
											  .andExpect(view().name("owners/createOrUpdateOwnerForm"))
											  .andExpect(model().attributeExists("owner"));
	}
	
	@Test
	void testUpdateOwner() throws Exception{
		Owner owner = new Owner();
		owner.setId(1L);
		
		when(ownerService.save(ArgumentMatchers.any())).thenReturn(owner);
		
		mockMVC.perform(post("/owners/1/edit")).andExpect(status().is3xxRedirection())
											   .andExpect(view().name("redirect:/owners/1"));
	}

}
