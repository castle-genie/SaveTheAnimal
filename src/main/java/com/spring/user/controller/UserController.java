package com.spring.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.user.service.UserService;
import com.spring.user.vo.UserVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("userLogin")
@Slf4j
@RequestMapping("/user/*")
public class UserController {
	@Setter(onMethod_ = @Autowired)
	private UserService userService;
	
	@GetMapping("/login")
	public String userLogin() {
		log.info("user 로그인 화면");
		return "user/login";
	}
	
	@PostMapping("/login")
	public String userLoginProcess(UserVO login, Model model, RedirectAttributes ras, HttpSession session) {
		UserVO userLogin = userService.userLoginProcess(login);
		
		
		if (userLogin != null) {
			model.addAttribute("userLogin", userLogin); 
			session.setAttribute("userId", userLogin.getUserId());// 로그인 성공 시 세션에 사용자 아이디 저장
			return "/project/mainpage";// 성공하면 메인페이지 이동
		} else {
			ras.addFlashAttribute("errorMsg", "로그인 실패 : 아이디와 비밀번호를 확인해 주세요.");
			return "redirect:/user/login";
		}
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
			url="/";
		} else {
			ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요.");
			url="/user/join";
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
	public String findId() {
		log.info("아이디 찾기 화면");
		return "user/findId";
	}
	
	@PostMapping("/findId")
	public String findId(UserVO uvo, Model model, RedirectAttributes ras) {
		log.info("아이디 찾기 호출");		
		UserVO result = userService.findId(uvo); 
		
		if (result != null) {
			model.addAttribute("result", result);
			return "user/findId";
		} else { 
			ras.addFlashAttribute("msg", "가입 이메일이 아닙니다.");
			return "redirect:/user/findId";
		}
	}
	
	@GetMapping("/resetPwd")
	public String resetPwd() {
		log.info("아이디 찾기 화면");
		return "user/resetPwd";
	}
	
	
	
	@GetMapping("/mypage")
    public String mypage(HttpServletRequest request, Model model, RedirectAttributes ras) {
		// 세션 가져오기
		HttpSession session = request.getSession();
		// 세션에서 사용자 ID 가져오기
        String userId = (String) session.getAttribute("userId");
        
        if (userId == null) {
            // 세션에 사용자 ID가 없는 경우 메시지를 추가하고 로그인 페이지로 리다이렉트
            ras.addAttribute("errorMsg", "로그인이 필요합니다.");
            return "redirect:/login";
        }       
        // 사용자 정보 가져오기
        UserVO userinfo = userService.userInfo(userId);
        
        if (userinfo == null) {
            // 사용자 정보가 없는 경우 메시지를 추가하여 마이페이지로 이동
        	ras.addAttribute("errorMsg", "사용자 정보를 가져오는데 문제가 발생했습니다.");
        } else {
            // 사용자 정보가 있는 경우 모델에 추가
            model.addAttribute("userInfo", userinfo);
            //log.info(userinfo.toString());
        }
        
        return "user/myPage";
    }
	
	@GetMapping("/updateProfile")
	public String updateProfile(HttpServletRequest request, Model model) {
		// 세션 가져오기
		HttpSession session = request.getSession();
		// 세션에서 사용자 ID 가져오기
		String userId = (String) session.getAttribute("userId");
		
		// 사용자 정보 가져오기
        UserVO userInfo = userService.userInfo(userId);
		model.addAttribute("userInfo", userInfo);
		return "user/updateProfile";
	}
	
	
	@ResponseBody
	@PostMapping(value="/pwdConfirm", produces = "application/json; charset=UTF-8")
	public int pwdConfirm(@RequestBody UserVO uvo) {	
		int result = 0;
		result = userService.pwdConfirm(uvo);
		return result;			 
	} 
	
	
	@PostMapping("/updateProfile")
	public String updateProfile(UserVO uvo, Model model, RedirectAttributes ras) {
		log.info("회원정보 수정");
		int result = 0;
		log.info(uvo.toString());
		result = userService.updateProfile(uvo);
		
		if (result == 1) {		
			UserVO userInfo = userService.userInfo(uvo.getUserId());
			log.info("업데이트 성공");
			model.addAttribute("userInfo", userInfo);
			return "user/myPage";
		} else {
			ras.addFlashAttribute("errorMsg", "업데이트에 문제가 있어 다시 진행해 주세요.");
			return "redirect:/user/updateProfile";
		}

	}
	
	@GetMapping("/admin/userList")
	public String userList(@ModelAttribute UserVO uvo, Model model) {
		List<UserVO> userList = userService.userList(uvo);
		model.addAttribute("userList", userList);
		return "admin/user/userList";
	}
	
	
	
}
