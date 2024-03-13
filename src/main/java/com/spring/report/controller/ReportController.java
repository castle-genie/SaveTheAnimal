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

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
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
//		log.info("reportDetail 호출");
		ReportVO detail = reportService.reportDetail(rvo);
		model.addAttribute("detail", detail);
		return "admin/report/reportDetail";
	}
	
	@PostMapping("reportInsertFB")
	public String reportInsertFB(ReportVO rvo) throws Exception{
		reportService.reportInsertFB(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportInsertVB")
	public String reportInsertVB(ReportVO rvo) throws Exception{
		reportService.reportInsertVB(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportInsertAB")
	public String reportInsertAB(ReportVO rvo) throws Exception{
		reportService.reportInsertAB(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportInsertFC")
	public String reportInsertFC(ReportVO rvo) throws Exception{
		reportService.reportInsertFC(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportInsertVC")
	public String reportInsertVC(ReportVO rvo) throws Exception{
		reportService.reportInsertVC(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportInsertAC")
	public String reportInsertAC(ReportVO rvo) throws Exception{
		reportService.reportInsertAC(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("reportUpdate")
	public String reportUpdate(ReportVO rvo) {
//		log.info("reportUpdate 호출");
		reportService.reportUpdate(rvo);
//		log.info("rvo : " + rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportDelete")
	public String reportDelete(ReportVO rvo) throws Exception{
//		log.info("reportDelete call");
		reportService.reportDelete(rvo);
		return "redirect:/admin/report/reportList";
	}
	
	@PostMapping("reportModify")
	public String reportModify(ReportVO rvo) throws Exception{
//		log.info("reportModify call");
		reportService.reportModify(rvo);
		return "redirect:/admin/report/reportList";
	}
	

	
	
}
