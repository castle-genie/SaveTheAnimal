package com.spring.sanction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.sanction.service.SanctionService;
import com.spring.sanction.vo.SanctionVO;

@RequestMapping("/admin/sanction/*")
@Controller
public class SanctionController {
	
	@Autowired
	private SanctionService sanctionService;
	
	@PostMapping("sanctionInsert")
	public String sanctionInsert(SanctionVO svo) {
		sanctionService.sanctionInsert(svo);
		return "redirect:/admin/report/reportList";
	}
	
	
	
	
}
