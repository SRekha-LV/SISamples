package com.rules.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	
	 @RequestMapping(value = "/")
	public String hello (Model model) {
		System.out.println("----------- In hello controller");
		//model.addAttribute("name", "shasi");
		return "redirect:/rules";
	}

}
