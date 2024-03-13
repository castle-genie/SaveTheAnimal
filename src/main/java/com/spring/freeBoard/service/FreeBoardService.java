package com.spring.freeBoard.service;

import java.util.List;

import com.spring.freeBoard.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//자유게시판 목록
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	//자유게시판 게시글 상세조회
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);
	
	//public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);

}
