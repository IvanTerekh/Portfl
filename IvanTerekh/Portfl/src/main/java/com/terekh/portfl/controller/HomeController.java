package com.terekh.portfl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.terekh.portfl.service.PhotoService;

@Controller
public class HomeController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("photoes", this.photoService.findAll());
		return "home";
	}
	
}
