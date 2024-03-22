package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.board.vo.NoticeBoardVO;

@Mapper
public interface NoticeBoardDAO {
	// 자유게시판 글 목록
	public List<NoticeBoardVO> noticeBoardList(NoticeBoardVO nvo);

	public NoticeBoardVO noticeBoardDetail(NoticeBoardVO nvo);

	// 조회수 증가 메서드
	public boolean plusCnt(NoticeBoardVO nvo);

	// 게시글 등록하는 메서드
	public int insertNoticeBoard(NoticeBoardVO nvo);

	// 게시글 수정
	// public NoticeBoardVO updateFreeBoard(NoticeBoardVO nvo);
	public int updateNoticeBoard(NoticeBoardVO nvo);

	// 게시글 삭제
	// public void delete(int fboardId) throws Exception;
	public int deleteNoticeBoard(NoticeBoardVO nvo);

}
