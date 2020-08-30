package com.springguru.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String findOwners(Model model)
	{
		model.addAttribute("owner", new Owner());
		return "owners/findOwners";
	}
	
	@GetMapping("/lastName")
	public String findOwnersByLastName(@ModelAttribute Owner owner, Model model, BindingResult result)
	{
		if(owner.getLastName() == null)
			owner.setLastName("");
		
		List<Owner> owners = this.ownerService.findAllByLastNameLike(owner.getLastName());
		if(owners.size()==0)
		{
			result.rejectValue("lastName", "No owners found", "No owners found");
			return "owners/findOwners";
		}
			
		
		else if(owners.size()==1)
			return "redirect:/owners/"+owners.get(0).getId();
		
		else
		{
			model.addAttribute("owners", owners);
			return "owners/ownersList";
		}
			
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		Owner owner = this.ownerService.findById(ownerId);
		
		mav.addObject(owner);
		return mav;
	}
	
}
