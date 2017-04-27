package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.terekh.portfl.model.User;
import com.terekh.portfl.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/find")
	public String showUserPage(@RequestParam String username, Model model){
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "/users/user";
	}
	
}
