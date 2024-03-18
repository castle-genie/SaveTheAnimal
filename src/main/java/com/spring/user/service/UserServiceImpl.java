package com.spring.user.service;

import java.util.List;

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
	public int findUserByIdAndEmail(UserVO uvo) {
		int result = userDao.findUserByIdAndEmail(uvo);
		return result;
	}
	
	@Override
	public int resetPasswd(UserVO uvo) {
		int result = userDao.resetPasswd(uvo);
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
	public UserVO userInfo(String userId) {
		UserVO uvo = new UserVO();
		uvo.setUserId(userId);
		UserVO info = userDao.userInfo(uvo);
		return info;
	}
	
	@Override
	public int updateProfile(UserVO uvo) {
		int result = userDao.updateProfile(uvo);
		return result;
	}
	
	@Override
	public int userWithdrawal(UserVO uvo) {
		int result = userDao.userWithdrawal(uvo);
		return result;
	}
	
	// 회원 목록 조회
	@Override
	public List<UserVO> userList(UserVO uvo) {
		List<UserVO> list = null;
		list = userDao.userList(uvo);
		return list;
	}



	
	
}
