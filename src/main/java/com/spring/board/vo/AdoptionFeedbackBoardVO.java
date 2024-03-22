package com.spring.board.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class AdoptionFeedbackBoardVO {
	
	private int afboardId;		//입양후기글ID
	private String afboardTitle;		//입양후기글 제목
	private String afboardContent;		//입양후기글 내용
	private Date afboardDate;			//입양후기글 작성일
	private int afboardLike;			//입양후기글 좋아요수
	private int afboardCnt;			//입양후기글 조회수
	
	public String userId			="";	//입양후기글 작성자 회원ID 	
	
	private String reUserId 		= "";	//신고한 회원의 ID
	private String reportDetail		= "";	//신고 상세
	private int reportId			= 0;	//신고 ID
	private int reportSort			= 0;	//신고 구분
}