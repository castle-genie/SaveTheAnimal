package com.spring.comment.vo;

import java.sql.Date;

import lombok.Data;
@Data
public class AfcommentVO {
	private int afcommentId=0;			//댓글 고유ID
	private String afcommentContent="";		//댓글 내용
	private Date afcommentDate;			//댓글 작성일
	private int afboardId=0;				//입양후기글ID
	private String userId="";				//댓글 작성자 회원ID

}
