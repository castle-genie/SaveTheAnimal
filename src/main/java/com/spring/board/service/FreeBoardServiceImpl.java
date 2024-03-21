package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.FreeBoardDAO;
import com.spring.board.vo.FreeBoardVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	
	@Override
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = freeBoardDAO.freeBoardList(freeBoardVO);
		
		return freeBoardList;
	}
	
	//자유게시판 글 조회하는 메서드
	/*
	@Override
	public FreeBoardVO freeBoardDetail(int fboardId) {
		return freeBoardDAO.freeBoardDetail(fboardId);
	}
	*/
	
	
	@Override
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO) {
		FreeBoardVO freeBoardDetail = freeBoardDAO.freeBoardDetail(freeBoardVO);
		
		return freeBoardDetail;
	}
	
	//조회수 증가
	@Override
	public boolean plusCnt(FreeBoardVO freeBoardVO) {
		log.info("조회수증가 메서드(ServiceImpl)");
		return freeBoardDAO.plusCnt(freeBoardVO);
	}
	//게시글 등록
	@Override
	public int insertFreeBoard(FreeBoardVO freeBoardVO) {
		log.info("게시글등록 메서드(ServiceImpl)");
		return freeBoardDAO.insertFreeBoard(freeBoardVO);
	}
	
	//게시글 수정
	@Override
	public int updateFreeBoard(FreeBoardVO freeBoardVO) {
		int  updatefreeboard = freeBoardDAO.updateFreeBoard(freeBoardVO);
		return updatefreeboard;
		//return freeBoardDAO.updateFreeBoard(freeBoardVO);
	}
	
	//게시글 삭제
	@Override
	public int deleteFreeBoard(FreeBoardVO freeBoardVO) {
		log.info("deleteFreeBoard 메서드 실행");
		int deletefreeboard = freeBoardDAO.deleteFreeBoard(freeBoardVO);
		log.info("deleteFreeBoard 메서드 실행완료"+ deletefreeboard);
		return deletefreeboard;
		//return freeBoardDAO.freeBoardDelete(fboardId);
	}
	
	
	

}
