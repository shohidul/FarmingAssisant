package com.example.fassistant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/")
public class PublicController {
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}

//	@GetMapping("/login")
//	public String login() {
//		return "login.html";
//	}
}