package com.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/*")
@Controller
public class IndexController {
	@GetMapping("/")
	public String mainpage() {
		return "project/mainpage";
	}
	
	@GetMapping("admin")
	public String adminPage() {
		return"admin/adminMain";
	}
}
