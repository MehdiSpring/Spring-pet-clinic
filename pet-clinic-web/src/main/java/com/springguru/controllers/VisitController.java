package com.springguru.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springguru.model.Owner;
import com.springguru.model.Pet;
import com.springguru.model.Visit;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.VisitService;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}")
public class VisitController {

	private final OwnerService ownerService;
	private final PetService petService;
	private final VisitService visitService;
	
	
	public VisitController(OwnerService ownerService, PetService petService, VisitService visitService) {
		this.ownerService = ownerService;
		this.petService = petService;
		this.visitService = visitService;
	}


	@GetMapping("/visits/new")
	public String goToCreateTemplate(@PathVariable Long petId, Model model)
	{
		
		Pet pet = this.petService.findById(petId);
		model.addAttribute("pet",pet);
		
		Visit visit = new Visit();
		model.addAttribute("visit", visit);
		
		return "pets/createOrUpdateVisitForm";
		
	}
	
	@PostMapping("/visits/new")
	public String createVisit(@PathVariable Long ownerId, Visit visit, @PathVariable Long petId)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		visit.setDate(LocalDate.parse(visit.getStringDate(), formatter));
		
		Pet pet = this.petService.findById(petId);
		visit.setPet(pet);
		pet.getVisits().add(visit);
		
		this.petService.save(pet);
		
		return "redirect:/owners/"+ownerId;
	}
}
