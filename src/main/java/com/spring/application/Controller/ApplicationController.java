package com.spring.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.application.Service.ApplicationService;
import com.spring.application.vo.ApplicationVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
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
	
	@PostMapping("/applicationSubmit")
	public String applicationSubmit(HttpServletRequest request, Model model, RedirectAttributes ras, ApplicationVO applicationVO) {
        int result = 0;
        String url = "";
        
        result = service.applicationSubmit(applicationVO);
		if(result == 1) {
			url = "/project/volunteer";
		} else {
			ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요.");
			url = "/project/volunteer";
		}
		return "redirect:"+url;
	}
	
	@ResponseBody
	@GetMapping("/applicationList")
	public List<ApplicationVO> applicationView(ApplicationVO applicationVO) {
		List<ApplicationVO> applicationView = null;
		applicationView = service.applicationList(applicationVO);
		return applicationView;
	}
	
	@GetMapping("/applicationView")
	public String applicationView() {
		return "application/applicationView";
	}
	
}
