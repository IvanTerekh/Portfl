package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping(path="/registration/step1")
	public String register () {
		return "registration/step1";
	}
	
	@PostMapping(path="/registration/step2")
	public String addUser(@RequestParam String fullName
			, @RequestParam String username
			, @RequestParam String email
			, @RequestParam String password
			, @RequestParam String passwordRepeat
			, Model model) {
		if (!password.equals(passwordRepeat)){
			return "redirect:/registration/step1";
		}
		if (this.userService.findByUsername(username) != null){
			return "redirect:/registration/step1";
		}
		User user = new User(username, fullName,  password, email);
		userService.create(user);
		model.addAttribute("username", username);
		model.addAttribute("genders", Gender.values());
		return "registration/step2";
	}
	
	@PostMapping(path="/registration/step3")
	public String addUserInfo(@RequestParam Integer birthYear
			, @RequestParam Integer height
			, @RequestParam Integer weight
			, @RequestParam String gender
			, @RequestParam String username) {
		User user = userService.findByUsername(username);
		user.setBirthYear(birthYear);
		user.setHeight(height);
		user.setWeight(weight);
		user.setGender(Gender.genderFromString(gender));
		user.setValid(true);
		this.userService.update(user);
		return "redirect:/login";
	}
	
}
