package com.spring.freeBoard.service;

import java.util.List;

import com.spring.freeBoard.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//자유게시판 목록
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	//게시글 상세보기
	public FreeBoardVO freeBoardDetail(int fboardId);
	
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);
	
	//조회수 증가 메서드
	public boolean plusCnt(int fboardId);
	
	
	
	//public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);

}
