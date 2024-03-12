package com.spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.vo.UserVO;

import lombok.Setter;
@Service
public class UserServiceImpl implements UserService {
	@Setter(onMethod_ = @Autowired)
	private UserDao userDao;

	@Override
	public UserVO userLoginProcess(UserVO uvo) {
		UserVO result = userDao.userLoginProcess(uvo);
		return result;
	}
	
	@Override
	public UserVO findId(UserVO uvo) {
		UserVO result = userDao.findId(uvo);
		return result;
	}
	
	@Override
	public int findIdCheck(UserVO uvo) {
		int result = 0;
		result = userDao.findIdCheck(uvo);
		return result;
	}

	@Override
	public int userJoin(UserVO uvo) {
		int result = userDao.userJoin(uvo); 
		return result;
	}
	
	@Override
	public int idCheck(UserVO uvo) {
		int result = 0;
		result = userDao.idCheck(uvo);
		return result;
	}
	@Override
	public int phoneCheck(UserVO uvo) {
		int result = 0;
		result = userDao.phoneCheck(uvo);
		return result;
	}
	@Override
	public int emailCheck(UserVO uvo) {
		int result = 0;
		result = userDao.emailCheck(uvo);
		return result;
	}
	
	@Override
	public int pwdConfirm(UserVO uvo) {
		int result = 0;
		result = userDao.pwdConfirm(uvo);
		return result;
	}
	
	// 회원 정보 조회
	@Override
	public UserVO userInfo(UserVO uvo) {
		UserVO info = null;
		info = userDao.userInfo(uvo);
		return info;
	}
	
	@Override
	public int userUpdate(UserVO uvo) {
		int result = userDao.userUpdate(uvo);
		return result;
	}

	



	
	
}
