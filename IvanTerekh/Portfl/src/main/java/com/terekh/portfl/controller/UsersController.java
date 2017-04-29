package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terekh.portfl.model.User;
import com.terekh.portfl.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{username}")
	public String showUserPage(@PathVariable String username, Model model){
		User user = userService.findByUsername(username);
		if (user == null){
			return "users/404";
		}
		model.addAttribute("user", user);
		return "/users/user";
	}
	
	@GetMapping("/mypage")
	public String showPersonalPage(Model model){
		User user = userService.getAuthorizedUser();
		model.addAttribute("user", user);
		return "/users/user";
	}
	
}
