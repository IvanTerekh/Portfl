package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.terekh.portfl.dao.UserDao;

@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("users", userDao.findAll().get(0).getName());
		return "home";
	}

}
