package com.spring.donate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donate")
public class DonateController {
	@GetMapping("/donatepay")
	public String donatepay() {
		return "/donate/donatePay";
	}
}
