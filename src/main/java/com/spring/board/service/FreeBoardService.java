package com.spring.board.service;

import java.util.List;

import com.spring.board.vo.FreeBoardVO;

public interface FreeBoardService {
	
	//자유게시판 목록
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	//게시글 상세보기
	//public FreeBoardVO freeBoardDetail(int fboardId);
	
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);
	
	//조회수 증가 메서드
	public boolean plusCnt(FreeBoardVO freeBoardVO);
	
	//게시글 등록하는 메서드
	public int insertFreeBoard(FreeBoardVO freeBoardVO);
	//public void freeBoardCreate(FreeBoardVO freeBoardVO);
	
	//게시글 수정
	//public void update(FreeBoardVO freeBoardVO) throws Exception;
	public int updateFreeBoard(FreeBoardVO freeBoardVO);
	
	//게시글 삭제
	//public void delete(int fboardId) throws Exception;
	public int deleteFreeBoard(FreeBoardVO freeBoardVO);

	//게시글 갯수 카운트
	public int freeBoardListCnt(FreeBoardVO freeBoardVO);
	

}
