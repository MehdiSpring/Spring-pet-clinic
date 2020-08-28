package com.springguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springguru.model.Owner;

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
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		Owner owner = this.ownerService.findById(ownerId);
		
		mav.addObject(owner);
		return mav;
	}
	
}
