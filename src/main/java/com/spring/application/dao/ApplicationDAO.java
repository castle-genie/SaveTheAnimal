package com.spring.application.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.application.vo.ApplicationVO;

@Mapper
public interface ApplicationDAO {
	public int applicationCount(ApplicationVO applicationVO);
}
