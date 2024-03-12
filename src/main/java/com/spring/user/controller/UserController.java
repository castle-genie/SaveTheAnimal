package com.spring.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.user.service.UserService;
import com.spring.user.vo.UserVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("userLogin")
@Slf4j
public class UserController {
	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	@GetMapping("/login")
	public String userLoginForm() {
		log.info("user 로그인 화면 호출");
		return "user/login";
	}
	
	@PostMapping("/login")
	public String userLoginProcess(UserVO login, Model model, RedirectAttributes ras) {
		UserVO userLogin = userService.userLoginProcess(login);
		
		String url = "";
		if (userLogin != null) {
			model.addAttribute("userLogin", userLogin); 
			url = "/";// 성공하면 메인페이지 이동
		} else {
			ras.addFlashAttribute("errorMsg", "로그인 실패 : 아이디와 비밀번호를 확인해 주세요.");
			url = "/login";
		}
		return "redirect:"+url;
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		log.info("user 로그아웃 처리");
		sessionStatus.setComplete();
		return "/project/mainpage"; // 메인페이지 이동
	}
	
	@GetMapping("/join")
	public String join() {
		log.info("회원가입 화면");
		return "user/join";
	}
	
	@PostMapping("/join")
	public String userJoin(UserVO uvo, RedirectAttributes ras) {
		int result = 0;
		String url = "";
		
		result = userService.userJoin(uvo);
		if (result ==1) {
			url="/project/mainpage";
		} else {
			ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요.");
			url="/join";
		}
		return "redirect:"+url;
	}
	
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheck(UserVO uvo) {
		int result = 0;
		result = userService.idCheck(uvo);
		return result;
	}
	@ResponseBody
	@PostMapping("/phoneCheck")
	public int phoneCheck(UserVO uvo) {
		int result = 0;
		result = userService.phoneCheck(uvo);
		return result;
	}
	@ResponseBody
	@PostMapping("/emailCheck")
	public int emailCheck(UserVO uvo) {
		int result = 0;
		result = userService.emailCheck(uvo);
		return result;
	}
	
	/*@ResponseBody
	@PostMapping("/checkDuplicate")
	public int checkDuplicate(UserVO uvo) {
		int result = 0;
		result = userService.checkDuplicate(uvo);
		return result;
	}*/
	
	@GetMapping("/findId")
	public String findIdForm() {
		log.info("아이디 찾기 화면");
		return "user/findIdForm";
	}

	@PostMapping("/findId")
	public String findId(UserVO uvo, Model model) {
		log.info("아이디 찾기 호출");
		UserVO result = userService.findId(uvo); 
		model.addAttribute("result", result);
		return "user/findId";
	}
	
}
