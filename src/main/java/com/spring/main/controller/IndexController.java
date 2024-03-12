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
<<<<<<< HEAD
	}	
=======
	}
	
	@GetMapping("admin")
	public String adminPage() {
		return"admin/adminMain";
	}
>>>>>>> 1a258f1d5fb851adda884777da4b72107f2a53b9
}
