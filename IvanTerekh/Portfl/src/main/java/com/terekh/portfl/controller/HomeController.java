package com.terekh.portfl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.terekh.portfl.dao.UserDao;
import com.terekh.portfl.entity.User;

@Controller
public class HomeController {

//    @Autowired
//    private UserDao userDao;

	@GetMapping("/home")
	public String home(Model model){
//		model.addAttribute("user", userDao.findAll().get(0));
//		for (User user : userDao.findAll()){
//			model.addAttribute("users", user);
//		}
		return "home";
	}
	
	@GetMapping("/")
	public String addUser(){
//		User user = new User();
//		initializeUser(user);
//		userDao.save(user);
		return "home";
	}

	private void initializeUser(User user) {
		user.setBirthYear(1999);
		user.setHeight(175);
		user.setName("NewName");
		user.setWeight(51);		
	}

}
