package com.terekh.portfl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.terekh.portfl.model.Photo;
import com.terekh.portfl.model.User;
import com.terekh.portfl.security.SecurityHelper;
import com.terekh.portfl.service.PhotoService;
import com.terekh.portfl.service.UserService;

@Controller
public class PhotoAddingController {

	@Autowired
	PhotoService photoService;

	@Autowired
	UserService userService;

	@PostMapping(path = "/addavatar/{username}", consumes = "application/jsonurls")
	public void addAvatar(@RequestBody String jsonUrls, @PathVariable String username, Model model) {
		User user = this.userService.findByUsername(username);
		user.setAvatarUrl((String) this.parseJsonUrls(jsonUrls).get(0));
		this.userService.update(user);
	}

	@PostMapping(path = "/addphotoes", consumes = "application/jsonurls")
	public void addPhotoes(@RequestBody String jsonUrls, Model model) {
		Photo[] photoes = this.initializePhotoes(this.parseJsonUrls(jsonUrls));
		for (Photo photo : photoes) {
			this.photoService.create(photo);
		}
	}

	private List<Object> parseJsonUrls(String jsonUrls) {
		BasicJsonParser jsonParser = new BasicJsonParser();
		List<Object> urls = jsonParser.parseList(jsonUrls);
		return urls;
	}

	private Photo[] initializePhotoes(List<Object> urls) {
		Photo[] photoes = new Photo[urls.size()];
		for (int i = 0; i < urls.size(); i++) {
			photoes[i] = new Photo((String) urls.get(i));
		}
		return photoes;
	}

}
