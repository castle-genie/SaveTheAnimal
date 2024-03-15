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
		/*
<<<<<<< HEAD
*/
		/*
<<<<<<< HEAD
	}	
=======
*/
		/*
=======
>>>>>>> 4d18c99ca1a7b4c704ff9eddc23634005d04cdda
*/
	}
=======
	}	

>>>>>>> f88698c18ec78c66c2a37e68f578dfeb5b1496b8
	
	@GetMapping("admin")
	public String adminPage() {
		return"admin/adminMain";
	}
	/*
<<<<<<< HEAD
//>>>>>>> 1a258f1d5fb851adda884777da4b72107f2a53b9
=======
>>>>>>> 4d18c99ca1a7b4c704ff9eddc23634005d04cdda
*/
}
