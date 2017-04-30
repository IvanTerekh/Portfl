package com.terekh.portfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RatingController {
	
	@PostMapping(path="/addrating", consumes = "application/rating")
	public String addRating(){
		return "home";
	}

}
