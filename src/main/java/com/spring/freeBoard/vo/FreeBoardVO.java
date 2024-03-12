package com.spring.freeBoard.vo;

import lombok.Data;

@Data
public class FreeBoardVO {
	
	private int fboardId;			//자유글ID
	private String fboardTitle			="";		//자유글 제목
	private String fboardContent		="";		//자유글 내용
	private String fboardDate;			//자유글 작성일
	private int fboardLike			=0;			//자유글 좋아요수
	private int fboardCnt				=0;			//자유글 조회수
	
	private String userId;				//자유글 작성자 회원ID 	

}
