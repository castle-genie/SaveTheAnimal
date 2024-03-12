package com.spring.freeBoard.vo;

import lombok.Data;

@Data
public class FreeBoardVO {
	
	private String fboard_title;		//자유글 제목
	private String fboard_content;		//자유글 내용
	private String fboard_date;			//자유글 작성일
	private int fboard_like;			//자유글 좋아요수
	private int fboard_cnt;			//자유글 조회수
	
	private String user_id;				//자유글 작성자 회원ID 	

}
