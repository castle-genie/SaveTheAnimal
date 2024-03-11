package com.spring.user.service;

import com.spring.user.vo.UserVO;

public interface UserService {
	public UserVO userLoginProcess(UserVO uvo); // 회원 로그인
	public UserVO findId(UserVO uvo); 			// 아이디 찾기
	public int findIdCheck(UserVO uvo); 		// 회원 아이디 확인	
	
	public int userJoin(UserVO uvo); 			// 회원 가입
	public int idCheck(UserVO uvo);				// 회원 아이디 중복 체크
	public int phoneCheck(UserVO uvo);			// 핸드폰번호 중복 체크
	public int emailCheck(UserVO uvo);			// 이메일 중복 체크
	//public int checkDuplicate(UserVO uvo); // 중복 체크 : 아이디, 핸드폰번호, 이메일
	
	
	public UserVO userInfo(UserVO uvo);			// 회원 정보 조회	
	public int pwdConfirm(UserVO uvo);			// 비밀번호 확인
	public int userUpdate(UserVO uvo); 			// 회원 정보 수정
	//public int userDelete(UserVO uvo); // 회원 탈퇴
}
