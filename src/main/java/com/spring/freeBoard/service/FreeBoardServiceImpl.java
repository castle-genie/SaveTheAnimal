package com.spring.freeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.freeBoard.dao.FreeBoardDAO;
import com.spring.freeBoard.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	
	@Override
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = freeBoardDAO.freeBoardList(freeBoardVO);
		
		return freeBoardList;
	}
	
	//자유게시판 글 조회하는 메서드
	@Override
	public FreeBoardVO freeBoardDetail(int fboardId) {
		return freeBoardDAO.freeBoardDetail(fboardId);
	}
	
	
	@Override
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		FreeBoardVO freeBoardDetail = freeBoardDAO.freeBoardDetail(freeBoardVO);
		
		return freeBoardDetail;
	}
	
	//조회수 증가
	@Override
	public boolean plusCnt(int fboardId) {
		return freeBoardDAO.plusCnt(fboardId);
	}
	
	/*
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		
	}
	*/
	
	
	

}
