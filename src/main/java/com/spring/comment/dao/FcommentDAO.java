package com.spring.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.comment.vo.FcommentVO;

@Mapper
public interface FcommentDAO {
	public List<FcommentVO> fcommentList(FcommentVO fcommentvo);

	 
	
	
	

}
