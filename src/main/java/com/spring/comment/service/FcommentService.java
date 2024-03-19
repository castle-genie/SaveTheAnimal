package com.spring.comment.service;

import java.util.List;

import com.spring.comment.vo.FcommentVO;

public interface FcommentService {
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

}
