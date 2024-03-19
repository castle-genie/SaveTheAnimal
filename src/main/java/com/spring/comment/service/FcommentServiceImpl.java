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
	/*
	// 댓글 조회
	@Override
	public List<FcommentVO> list(int fboardId) throws Exception{
		return fcommentDAO.list(fboardId);
	}
	
	//댓글 작성
	@Override
	public void FcommentInsert(FcommentVO fcommentvo) throws Exception{
		fcommentDAO.FcommentInsert(fcommentvo);
	}
	
	//댓글 수정
	@Override
	public void FcommentUpdate(FcommentVO fcommentvo) throws Exception{
		fcommentDAO.FcommentUpdate(fcommentvo);
	}
	
	//댓글 삭제
	@Override
	public void FcommentDelete(FcommentVO fcommentvo) throws Exception{
		fcommentDAO.FcommentDelete(fcommentvo);
	}
	*/
	
	@Override
	public List<FcommentVO> list(int fboardId) throws Exception{
		return fcommentDAO.list(fboardId);
	}
	
	//댓글 작성
	@Override
	public FcommentVO FcommentInsert(FcommentVO fcommentvo) throws Exception{
		return fcommentDAO.FcommentInsert(fcommentvo);
	}
	
	//댓글 수정
	@Override
	public FcommentVO FcommentUpdate(FcommentVO fcommentvo) throws Exception{
		return fcommentDAO.FcommentUpdate(fcommentvo);
	}
	
	//댓글 삭제
	@Override
	public FcommentVO FcommentDelete(FcommentVO fcommentvo) throws Exception{
		return fcommentDAO.FcommentDelete(fcommentvo);
	}
	
}
