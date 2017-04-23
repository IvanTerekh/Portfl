package com.terekh.portfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public String lol;

	@GetMapping("/")
	public String home(){
		return "home";
	}

}
