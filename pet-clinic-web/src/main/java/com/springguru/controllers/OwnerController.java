package com.springguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springguru.service.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}


	@RequestMapping({"","/","/index","/index.html"})
	public String listAllOwners(Model model)
	{
		model.addAttribute("owners", this.ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners()
	{
		return "notImplemented";
	}
}
