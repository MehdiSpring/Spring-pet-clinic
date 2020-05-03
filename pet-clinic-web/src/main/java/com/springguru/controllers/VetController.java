package com.springguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vet")
@Controller
public class VetController {

	@RequestMapping({"","/","/index","/index.html"})
	public String vetIndex()
	{
		return "vet/index";
	}
}
