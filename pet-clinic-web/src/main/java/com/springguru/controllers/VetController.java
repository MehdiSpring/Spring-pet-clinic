package com.springguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springguru.service.VetService;

@RequestMapping("/vet")
@Controller
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({"","/","/index","/index.html"})
	public String vetIndex(Model model)
	{
		model.addAttribute("vets", this.vetService.findAll());
		return "vet/index";
	}
}
