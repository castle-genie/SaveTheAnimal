package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.NoticeBoardDAO;
import com.spring.board.vo.NoticeBoardVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired
	private NoticeBoardDAO noitceBoardDAO;
	
	
	@Override
	public List<NoticeBoardVO> noticeBoardList(NoticeBoardVO nvo){
		List<NoticeBoardVO> noticeBoardList = noitceBoardDAO.noticeBoardList(nvo);
		
		return noticeBoardList;
	}
	
	@Override
	public NoticeBoardVO noticeBoardDetail(NoticeBoardVO nvo) {
		NoticeBoardVO noticeBoardDetail = noitceBoardDAO.noticeBoardDetail(nvo);
		
		return noticeBoardDetail;
	}
	
	//조회수 증가
	@Override
	public boolean plusCnt(NoticeBoardVO nvo) {
		log.info("조회수증가 메서드(ServiceImpl)");
		return noitceBoardDAO.plusCnt(nvo);
	}
	//게시글 등록
	@Override
	public int insertNoticeBoard(NoticeBoardVO nvo) {
		log.info("게시글등록 메서드(ServiceImpl)");
		return noitceBoardDAO.insertNoticeBoard(nvo);
	}
	
	//게시글 수정
	@Override
	public int updateNoticeBoard(NoticeBoardVO nvo) {
		int  updateNoticeBoard = noitceBoardDAO.updateNoticeBoard(nvo);
		return updateNoticeBoard;
	}
	
	//게시글 삭제
	@Override
	public int deleteNoticeBoard(NoticeBoardVO nvo) {
		log.info("deleteFreeBoard 메서드 실행");
		int deleteNoticeBoard = noitceBoardDAO.deleteNoticeBoard(nvo);
		log.info("deleteFreeBoard 메서드 실행완료"+ deleteNoticeBoard);
		return deleteNoticeBoard;
	}

}
