package com.spring.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.application.vo.ApplicationVO;

@Mapper
public interface ApplicationDAO {
	public int applicationCount(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationList(ApplicationVO applicationVO);
	
	public int applicationSubmit(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationView(ApplicationVO applicationVO);
}
