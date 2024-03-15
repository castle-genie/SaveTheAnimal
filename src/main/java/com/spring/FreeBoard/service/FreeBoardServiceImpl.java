package com.spring.FreeBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.FreeBoard.dao.FreeBoardDAO;
import com.spring.FreeBoard.vo.FreeBoardVO;

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
	//게시글 등록
	@Override
	public int freeBoardCreate(FreeBoardVO freeBoardVO) {
		return freeBoardDAO.freeBoardCreate(freeBoardVO);
	}
	
	//게시글 수정
	@Override
	public void update(FreeBoardVO freeBoardVO) throws Exception {
		
		freeBoardDAO.update(freeBoardVO);
	}
	
	//게시글 삭제
	@Override
	public boolean freeBoardDelete(int fboardId) {
		return freeBoardDAO.freeBoardDelete(fboardId);
	}
	/*
	@Override
	public void delete(int fboardId) throws Exception {
		freeBoardDAO.delete(fboardId);
	}
	*/
	
	/*
	@Override
	public int freeBoardCreate(FreeBoardVO freeBoardVO) {
		int result = freeBoardDAO.freeBoardCreate(freeBoardVO);
		return result;
	}
	*/
	/*
	@Override
	public void freeBoardCreate(FreeBoardVO freeBoardVO) {
	}
	*/
	
	/*
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		
	}
	*/
	
	
	

}
