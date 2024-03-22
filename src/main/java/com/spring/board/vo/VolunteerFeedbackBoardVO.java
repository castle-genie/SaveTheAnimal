package com.spring.board.vo;

import java.sql.Date;

import lombok.Data;
@Data
public class VolunteerFeedbackBoardVO {
	private int vfboardId;		//봉사후기글ID
	private String vfboardTitle;		//봉사후기글 제목
	private String vfboardContent;		//봉사후기글 내용
	private Date vfboardDate;			//봉사후기글 작성일
	private int vfboardLike;			//봉사후기글 좋아요수
	private int vfboardCnt;			//봉사후기글 조회수
	
	public String userId			="";	//봉사후기글 작성자 회원ID 	
	
	private String reUserId 		= "";	//신고한 회원의 ID
	private String reportDetail		= "";	//신고 상세
	private int reportId			= 0;	//신고 ID
	private int reportSort			= 0;	//신고 구분

}
