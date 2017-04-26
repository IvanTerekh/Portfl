package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.terekh.portfl.model.Gender;
import com.terekh.portfl.model.User;
import com.terekh.portfl.model.UserRole;
import com.terekh.portfl.service.UserService;

@Controller
public class RegestrationController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/registration")
	public String register () {
		return "registration";
	}
	
	@PostMapping(path="/registration")
	public String addUser(@RequestParam String username
			, @RequestParam String email
			, @RequestParam String password
			, @RequestParam String passwordRepeat) {
		if (!password.equals(passwordRepeat)){
			return "sasai";
		}
		User user = new User(username, password, email);
		user.setBirthYear(2000);
		user.setGender(Gender.GENDER_AGENDER_MALE);
		user.setHeight(170);
		user.setWeight(82);
		user.setRole(UserRole.ROLE_USER);
		userService.create(user);
		return "redirect:/";
	}
	
}
