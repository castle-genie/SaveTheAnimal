package com.spring.user.dao;


import org.apache.ibatis.annotations.Mapper;

import com.spring.user.vo.UserVO;


@Mapper
public interface UserDao {
	
	public UserVO userLoginProcess(UserVO uvo); // 유저 로그인		
	
	public UserVO findId(UserVO uvo); 			// 아이디 찾기		
	public int resetPasswd(UserVO uvo);			// 비밀번호 재설정
	
	public int userJoin(UserVO uvo); 			// 회원 가입	
	public int idCheck(UserVO uvo);				// 아이디 중복 체크
	public int phoneCheck(UserVO uvo);			// 핸드폰번호 중복 체크
	public int emailCheck(UserVO uvo);			// 이메일 중복 체크
	//public int checkDuplicate(UserVO uvo); // 중복 체크 : 아이디, 핸드폰번호, 이메일
	
	public UserVO userInfo(UserVO uvo); 		// 내정보 확인 - 상세 조회	
	public int userUpdate(UserVO uvo); 			// 회원정보 수정
	public int pwdConfirm(UserVO uvo);			// 비밀번호 일치 확인

	
	
	//public int userDelete(UserVO uvo);// 회원 삭제..ㄷㄷ
	
	
	//public int userListCnt(UserVO uvo); // users 테이블의 전체 레코드 수 : 페이징처리시 필요

	//public List<UserVO> userList(UserVO uvo); //회원 목록 조회
	
	
}
