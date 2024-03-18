package com.spring.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.comment.dao.FcommentDAO;
import com.spring.comment.vo.FcommentVO;

@Service
public class FcommentServiceImpl implements FcommentService{
	
	@Autowired
	private FcommentDAO fcommentDAO;
	
	// 댓글 목록
	@Override
	public List<FcommentVO> list(int fboardId) {
		return fcommentDAO.list(fboardId);
	}
	
	// 댓글 작성
	@Override
	public void create(FcommentVO vo) {
		fcommentDAO.create(vo);
	}
	
	// 댓글 수정
	@Override
	public void update(FcommentVO vo) {
		//TODO Auto-generated method stub
	}
	
	// 댓글 삭제
	@Override
	public void delete(int userId) {
		//TODO Auto-generated method stub
	}
}
