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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.common.vo.PageDTO;
import com.spring.user.service.UserService;
import com.spring.user.vo.UserVO;
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
	public String userLoginProcess(UserVO login, Model model, RedirectAttributes ras) {
		UserVO userLogin = userService.userLoginProcess(login);
				
		if (userLogin != null) {
			model.addAttribute("userLogin", userLogin); 
			return "redirect:/";// 성공하면 메인페이지 이동
		} else {
			ras.addFlashAttribute("errorMsg", "로그인 실패 : 아이디와 비밀번호를 확인해 주세요.");
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus, HttpSession session) {
		log.info("user 로그아웃 처리");
		sessionStatus.setComplete();
		//session.removeAttribute("userId");
		return "redirect:/"; // 메인페이지 이동
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
		log.info("비밀번호 재설정 화면");
		return "user/resetPwd";
	}

	@PostMapping("/resetPwd")
	public String resetPwd(UserVO uvo, Model model, RedirectAttributes ras) {
		log.info("임시비밀번호 업데이트 호출");	
		log.info(uvo.toString());	
		
		// 임시 비밀번호 생성
		String tempPassword = userService.generateTempPasswd();
		log.info(tempPassword);
		uvo.setUserPasswd(tempPassword);
		
		int isUpdate = 0;
		isUpdate = userService.resetPasswd(uvo);
		
		UserVO result = new UserVO(); // 임시 비밀번호 vo
		result.setUserPasswd(tempPassword);	
		
		if (isUpdate == 1 && result != null) {		
			log.info("업데이트 성공");
			model.addAttribute("isUpdate", isUpdate);
			model.addAttribute("result", result);
			return "user/resetPwd";
		} else {
			log.info("업데이트 실패");
			ras.addFlashAttribute("msg", "임시비밀번호 발급 처리에 문제가 있어 다시 진행해 주세요.");
			return "redirect:/user/resetPwd";
		}
	}
	
	@ResponseBody
	@PostMapping(value="/findUserByIdAndEmail", produces="application/json; charset=UTF-8")
	public int findUserByIdAndEmail(@RequestBody UserVO uvo) {
		int result = 0;
		result = userService.findUserByIdAndEmail(uvo);
		return result;
	}
		
	
	@GetMapping("/mypage")
    public String mypage(@SessionAttribute("userLogin") UserVO userLogin, Model model, RedirectAttributes ras) {
		//log.info("mypage 호출");
		// 세션에서 ID 가져오기
        String userId = (String) userLogin.getUserId();
        log.info(userId);
        
        if (userId == null) {
            ras.addAttribute("errorMsg", "로그인이 필요합니다.");
            return "user/login";
        } else {   
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
    }
	
	@GetMapping("/updateProfile")
	public String updateProfile(@SessionAttribute("userLogin") UserVO userLogin, Model model) {
		// 세션에서 ID 가져오기
        String userId = (String) userLogin.getUserId();
		
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
			return "/user/myPage";
		} else {
			ras.addFlashAttribute("errorMsg", "업데이트에 문제가 있어 다시 진행해 주세요.");
			return "redirect:/user/updateProfile";
		}

	}
	
	
	@PostMapping("/userWithdrawal")
	public String userWithdrawal(UserVO uvo, RedirectAttributes ras) {
		log.info("회원탈퇴 처리");
		
		int result = 0;
		String url = "";
		
		result = userService.userWithdrawal(uvo);
		if (result ==1) {
			url="/user/logout"; // 로그아웃 처리
		} else {
			ras.addFlashAttribute("errorMsg", "탈퇴처리에 문제가 있어 다시 진행해 주세요.");
			url="/user/mypage"; // 마이페이지
		}
		return "redirect:"+url;
	}
	
	
	@GetMapping("/userList")
	public String userList(@ModelAttribute UserVO uvo, Model model) {
		log.info("userList 호출");
		List<UserVO> userList = userService.userList(uvo);
		model.addAttribute("userList", userList);
		
		int total = userService.userListCnt(uvo);
		
		model.addAttribute("pageMaker", new PageDTO(uvo, total));				
		return "admin/user/userList";
	}
	
	/* 자바단에서 세션에서 꺼내온 값 사용하는 방법 
	@GetMapping("/board")
	public String process(@SessionAttribute("adminLogin") AdminLoginVO adminLoginVO) {
		adminLoginVO.getAdminId(); // 세션에서 얻은 값.
		return "";
	}*/
	
	/* jsp : ${adminLogin.adminId} */
	
	/* javascript : let adminId = "${adminLogin.adminId}"; */

}
