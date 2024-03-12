package com.spring.freeBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.freeBoard.vo.FreeBoardVO;

@Mapper
public interface FreeBoardDAO {
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);

}
