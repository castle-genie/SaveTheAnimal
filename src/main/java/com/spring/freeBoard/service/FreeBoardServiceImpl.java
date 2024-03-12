package com.spring.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.freeBoard.dao.FreeBoardDAO;
import com.spring.freeBoard.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDAO fbDAO;
	
	
	@Override
	public List<FreeBoardVO> freeBoardList(FreeBoardVO fbvo){
		List<FreeBoardVO> freeBoardList = fbDAO.freeBoardList(fbvo);
		
		return freeBoardList;
	}
	
	/*
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		
	}
	*/
	
	
	

}
