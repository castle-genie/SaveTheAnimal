package com.spring.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.comment.vo.FcommentVO;

@Mapper
public interface FcommentDAO {
<<<<<<< HEAD
	/*
	//댓글 조회
	public List<FcommentVO> list(int fboardId) throws Exception;
	
	//댓글 작성
	public void FcommentInsert(FcommentVO fcommentvo) throws Exception;
	
	//댓글 수정
	public void FcommentUpdate(FcommentVO fcommentvo) throws Exception;
	
	//댓글 삭제
	public void FcommentDelete(FcommentVO fcommentvo) throws Exception;
	*/
	
	//댓글 조회
	public List<FcommentVO> list(int fboardId) throws Exception;
	
	//댓글 작성
	public FcommentVO FcommentInsert(FcommentVO fcommentvo) throws Exception;
	
	//댓글 수정
	public FcommentVO FcommentUpdate(FcommentVO fcommentvo) throws Exception;
	
	//댓글 삭제
	public FcommentVO FcommentDelete(FcommentVO fcommentvo) throws Exception;
	
=======
	// 댓글 조회
	public List<FcommentVO> fcommentList(FcommentVO fcommentvo);

	// 댓글 작성
	public int fcommentInsert(FcommentVO fcommentvo);

	// 댓글 수정
	public int fcommentUpdate(FcommentVO fcommentvo);

	// 댓글 삭제
	public int fcommentDelete(FcommentVO fcommentvo);

	 
>>>>>>> a85d71ee7582a32dafdaf288a388a4093451ac06
	
	
	

}
