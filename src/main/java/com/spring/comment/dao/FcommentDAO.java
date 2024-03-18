package com.spring.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.comment.vo.FcommentVO;

@Mapper
public interface FcommentDAO {
	
	//댓글 목록
	public List<FcommentVO> list(int fboardId);
	
	//댓글 입력
	public void create(FcommentVO vo);
	
	//댓글 수정
	public void update(FcommentVO vo);
	
	//댓글 삭제
	public void delete(int fcommentId);
	

}
