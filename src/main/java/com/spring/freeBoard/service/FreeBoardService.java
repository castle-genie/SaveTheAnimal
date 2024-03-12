package com.spring.freeBoard.service;

import java.util.List;

import com.spring.freeBoard.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//게시물 목록 조회
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	//public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);

}
