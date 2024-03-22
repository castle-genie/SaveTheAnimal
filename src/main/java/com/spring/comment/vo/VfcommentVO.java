package com.spring.comment.vo;

import java.sql.Date;

import lombok.Data;
@Data
public class VfcommentVO {
	private int vfcommentId=0;			//댓글 고유ID
	private String vfcommentContent="";		//댓글 내용
	private Date vfcommentDate;			//댓글 작성일
	private int vfboardId=0;				//봉사후기글ID
	private String userId="";				//댓글 작성자 회원ID

}
