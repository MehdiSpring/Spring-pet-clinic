package com.springguru.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springguru.model.Owner;
import com.springguru.model.Pet;
import com.springguru.model.PetType;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	
	private final OwnerService ownerService;	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public PetController(OwnerService ownerService,PetTypeService petTypeService,PetService petService) {
		
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
		this.petService = petService;
	}


	@ModelAttribute("types")
	public Set<PetType> populatePetTypes() {
		return this.petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return this.ownerService.findById(ownerId);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@InitBinder("pet")
	public void initPetBinder(WebDataBinder dataBinder) {
		//dataBinder.setValidator(new PetValidator());
	}
	
	@GetMapping("/pets/new")
	public String goToCreateTemplate(@PathVariable Long ownerId,Model model)
	{
		
		Owner owner = this.ownerService.findById(ownerId); 
		Pet pet = new Pet();
		pet.setOwner(owner);		
		
		model.addAttribute("pet", pet);
		return "pets/createOrUpdatePetForm";
	}

	@PostMapping("/pets/new")
	public String createPet(@PathVariable Long ownerId, Pet pet)
	{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		pet.setBirthDate(LocalDate.parse(pet.getStringDate(), formatter));
		
		Owner owner = this.ownerService.findById(ownerId);
		owner.getPets().add(pet);
		pet.setOwner(owner);
		
		this.ownerService.save(owner);
		
		return "redirect:/owners/"+owner.getId();
	}
	
	@GetMapping("/pets/{petId}/edit")
	public String goToUpdateTemplate(@PathVariable Long ownerId,@PathVariable Long petId, Model model)
	{
		
		Pet pet = this.petService.findById(petId);
		
		model.addAttribute("pet", pet);
		return "pets/createOrUpdatePetForm";
		
	}
	
	@PostMapping("/pets/{petId}/edit")
	public String updatePet(@PathVariable Long ownerId,@PathVariable Long petId, Pet pet)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		pet.setBirthDate(LocalDate.parse(pet.getStringDate(), formatter));
		
		Owner owner = this.ownerService.findById(ownerId);
		pet.setOwner(owner);
		pet.setId(petId);
		Pet savedPet = this.petService.save(pet);
		
		return "redirect:/owners/"+savedPet.getOwner().getId();
	}
	
}
