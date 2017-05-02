package com.terekh.portfl.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.terekh.portfl.model.Photo;
import com.terekh.portfl.security.SecurityHelper;
import com.terekh.portfl.service.PhotoService;

@Controller
public class HomeController {
	
	@Autowired
	private PhotoService photoService;
	
	@GetMapping("/")
	public String home(Model model){
		List<Photo> photoes = this.photoService.findAll();
		Collections.reverse(photoes);
		model.addAttribute("photoes", photoes);
		this.setAuthorized(model);
		return "home";
	}
	
	private void setAuthorized(Model model){
		model.addAttribute("authorized", SecurityHelper.getUserId() >= 0);		
	}
	
}
