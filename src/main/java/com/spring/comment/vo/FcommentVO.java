package com.spring.comment.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class FcommentVO {
	
	/*
	CREATE TABLE Fcomment (
	fcomment_id	number		NOT NULL,
	fcomment_content	varchar2(150)		NOT NULL,
	fcomment_date	date	DEFAULT sysdate	NOT NULL,
	fboard_id	number		NOT NULL,
	user_id	varchar2(20)		NOT NULL
		);
	*/
	
	
	private int fcommentId;			//댓글 고유ID
	private String fcommentContent;		//댓글 내용
	private Date fcommentDate;			//댓글 작성일
	private int fboardId;				//자유글ID
	private String userId;				//댓글 작성자 회원ID

}
