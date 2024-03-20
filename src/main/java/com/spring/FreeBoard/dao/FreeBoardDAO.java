package com.spring.FreeBoard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.FreeBoard.vo.FreeBoardVO;

@Mapper
public interface FreeBoardDAO {
	
	//자유게시판 글 목록
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO);
	
	//게시물 상세조회
	//public FreeBoardVO viewDetail(freeBoardDetail fboardId);
	
	//게시글 상세보기
	public FreeBoardVO freeBoardDetail(int fboardId);
	
	
	public FreeBoardVO freeBoardDetail(FreeBoardVO freeBoardVO);
	
	
	//조회수 증가 메서드
	public boolean plusCnt(int fboardId);
	
	//게시글 등록하는 메서드
	public int insertFreeBoard(FreeBoardVO freeBoardVO);
	
	//public void freeBoardCreate(FreeBoardVO freeBoardVO);
	
	//게시글 수정
	//public void update(FreeBoardVO freeBoardVO) throws Exception;
	public boolean updateFreeBoard(FreeBoardVO freeBoardVO);
	
	//게시글 삭제
	//public void delete(int fboardId) throws Exception;
	public boolean freeBoardDelete(int fboardId);
	
	
	

}
