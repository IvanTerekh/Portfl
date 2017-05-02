package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terekh.portfl.model.User;
import com.terekh.portfl.model.UserRole;
import com.terekh.portfl.security.SecurityHelper;
import com.terekh.portfl.service.UserService;

@Controller
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users/{username}")
	public String showUserPage(@PathVariable String username, Model model){
		User user = userService.findByUsername(username);
		if (user == null)
			return "404";
		this.setAuthorized(model);
		updateRole(user);
		model.addAttribute("user", user);
		return "/users/user";
	}
	
	@GetMapping("/mypage")
	public String showMyPage(Model model){
		User user = userService.findOne(SecurityHelper.getUserId());
		user.setRole(UserRole.ROLE_ADMIN);
		model.addAttribute("user", user);
		model.addAttribute("authorized", true);
		return "/users/user";
	}

	private void updateRole(User user) {
		if (user.getId() == SecurityHelper.getUserId()){
			user.setRole(UserRole.ROLE_ADMIN);
		}
	}
	
	private void setAuthorized(Model model){
		model.addAttribute("authorized", SecurityHelper.getUserId() >= 0);		
	}
}
