package com.spring.volunteer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.volunteer.service.VolunteerService;
import com.spring.volunteer.vo.VolunteerVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/volunteer/*")
@Controller
public class VolunteerController {
	@Autowired
	private VolunteerService service;
	
	@ResponseBody
	@GetMapping(value="/volunteerList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO> volunteerList = null;
		volunteerList = service.volunteerList(volunteerVO);
		return volunteerList;
	}
	
	@GetMapping("/volunteerDetail")
	public String volunteerDetail(VolunteerVO volunteerVO, Model model) {
		VolunteerVO volunteerDetail = null;
		volunteerDetail = service.volunteerDetail(volunteerVO);
		model.addAttribute("detail", volunteerDetail);
		return "/volunteer/volunteerDetail";
	}
}
