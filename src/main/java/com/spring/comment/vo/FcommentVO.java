package com.spring.comment.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class FcommentVO {
	
	private int fcommentId;			//댓글 고유ID
	private String fcommentContent;		//댓글 내용
	private Date fcommentDate;			//댓글 작성일
	private Date fcommentUpdatedate;	//댓글 수정일자
	private int fboardId;				//자유글ID
	private String userId;				//댓글 작성자 회원ID

}
