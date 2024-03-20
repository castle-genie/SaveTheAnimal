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
	
	@Override
	public List<FcommentVO> fcommentList(FcommentVO fcommentvo){
		List<FcommentVO> list = null;
		list = fcommentDAO.fcommentList(fcommentvo);
		return list;
	}
	
}
