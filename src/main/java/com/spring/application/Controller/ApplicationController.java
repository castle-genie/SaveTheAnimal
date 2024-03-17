package com.spring.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.application.Service.ApplicationService;
import com.spring.application.vo.ApplicationVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/application/*")
public class ApplicationController {
	@Autowired
	private ApplicationService service;
	
	@ResponseBody
	@GetMapping("/{volunteerId}")
	public int applicationCount(@PathVariable("volunteerId") int volunteerId, ApplicationVO applicationVO) {
		int applicationCount = 0;
		applicationVO.setVolunteerId(volunteerId);
		applicationCount = service.applicationCount(applicationVO);
		return applicationCount;
	}
	
	@ResponseBody
	@PostMapping("/{volunteerId}")
	public List<ApplicationVO> applicationList(@PathVariable("volunteerId") int volunteerId, ApplicationVO applicationVO) {
		List<ApplicationVO> applicationList = null;
		applicationVO.setVolunteerId(volunteerId);
		applicationList = service.applicationList(applicationVO);
		return applicationList;
	}
	
}
