package com.springguru.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

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
import com.springguru.model.Pet;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.PetTypeService;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

	@Mock
	OwnerService ownerService;
	
	@Mock
	PetTypeService petTypeService;
	
	@Mock
	PetService petService;
	
	@InjectMocks
	PetController petController;
	
	MockMvc mockMVC;
	
	@BeforeEach
	void setUp() throws Exception {
		mockMVC = MockMvcBuilders.standaloneSetup(petController).build();
	}

	@Test
	void testGoToCreateTemplate() throws Exception {
		mockMVC.perform(get("/owners/1/pets/new")).andExpect(status().isOk())
												  .andExpect(view().name("pets/createOrUpdatePetForm"));
	}
	
	@Test
	void testCreatePet() throws Exception{
		Owner owner = new Owner();
		owner.setId(1L);
		
		when(ownerService.findById(ArgumentMatchers.anyLong())).thenReturn(owner );
		
		mockMVC.perform(post("/owners/1/pets/new").param("stringDate", "1998-09-28")).andExpect(status().is3xxRedirection())
																		 .andExpect(view().name("redirect:/owners/1"));
	}
	
	@Test
	void testGoToUpdateTemplate() throws Exception{
		Pet pet = new Pet();
		pet.setBirthDate(LocalDate.now());
		
		when(petService.findById(ArgumentMatchers.anyLong())).thenReturn(pet );
		
		mockMVC.perform(get("/owners/1/pets/1/edit")).andExpect(status().isOk())
													 .andExpect(view().name("pets/createOrUpdatePetForm"));
	}
	
	@Test
	void testUpdateTemplate() throws Exception{
		Owner owner=new Owner();
		owner.setId(1L);
		
		Pet pet=new Pet();
		pet.setOwner(owner);
		
		when(petService.save(ArgumentMatchers.any())).thenReturn(pet);
		
		mockMVC.perform(post("/owners/1/pets/1/edit").param("stringDate", "1998-09-28")).andExpect(status().is3xxRedirection())
													  .andExpect(view().name("redirect:/owners/1"));
	}

}
