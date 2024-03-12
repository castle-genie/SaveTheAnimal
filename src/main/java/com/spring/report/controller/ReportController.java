package com.spring.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.report.service.ReportService;
import com.spring.report.vo.ReportVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/admin/report/*")
@Controller
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@GetMapping("reportList")
	public String reportList(ReportVO rvo, Model model) {
//		log.info("reportList 호출");
		List<ReportVO> reportList = reportService.reportList(rvo);
		model.addAttribute("reportList", reportList);
		
		return "admin/report/reportList";		
	}
	
	
	@GetMapping("reportDetail")
	public String reportDetail(ReportVO rvo, Model model) {
		log.info("reportDetail 호출");
		ReportVO detail = reportService.reportDetail(rvo);
		model.addAttribute("detail", detail);
		return "admin/report/reportDetail";
	}
	
	@PostMapping("reportUpdate")
	public String reportDelete(ReportVO rvo) {
		log.info("reportUpdate 호출");
		reportService.reportUpdate(rvo);
		log.info("rvo : " + rvo);
		return "redirect:/admin/report/reportList";
	}
	

	
	
}
