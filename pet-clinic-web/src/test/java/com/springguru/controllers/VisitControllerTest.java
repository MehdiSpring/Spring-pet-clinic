package com.springguru.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springguru.model.Pet;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.VisitService;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {
	
	@Mock
	PetService petService;
	
	@InjectMocks
	VisitController visitController;
	
	MockMvc mockMVC;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMVC = MockMvcBuilders.standaloneSetup(visitController).build();
	}

	@Test
	void testGoToCreateTemplate() throws Exception{
		mockMVC.perform(get("/owners/1/pets/1/visits/new")).andExpect(status().isOk())
														   .andExpect(view().name("pets/createOrUpdateVisitForm"));
	}
	
	@Test
	void testCreateVisit() throws Exception{
		Pet pet = new Pet();
		when(petService.findById(ArgumentMatchers.anyLong())).thenReturn(pet);
		
		mockMVC.perform(post("/owners/1/pets/1/visits/new").param("stringDate", "1998-09-28")).andExpect(status().is3xxRedirection())
																							  .andExpect(view().name("redirect:/owners/1"));
	}

}
