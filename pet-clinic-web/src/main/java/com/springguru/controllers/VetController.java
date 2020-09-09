package com.springguru.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springguru.model.Vet;
import com.springguru.service.VetService;

//@RequestMapping("/vets")
@Controller
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"vets","/vets","/vets.html","/vets/index","/vets/index.html"})
	public String vetIndex(Model model)
	{
		
		model.addAttribute("vets", this.vetService.findAll());
		return "vet/index";
	}
	
	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> listOfVets()
	{
		return this.vetService.findAll();
	}
}
