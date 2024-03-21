package com.spring.FreeBoard.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class FreeBoardVO {
	
	private int fboardId;		//자유글ID
	private String fboardTitle;		//자유글 제목
	private String fboardContent;		//자유글 내용
	private Date fboardDate;			//자유글 작성일
	private int fboardLike;			//자유글 좋아요수
	private int fboardCnt;			//자유글 조회수
	
	public String userId			="";	//자유글 작성자 회원ID 	
	
	private String reUserId 		= "";	//신고한 회원의 ID
	private String reportDetail		= "";	//신고 상세
	private int reportId			= 0;	//신고 ID
	private int reportSort			= 0;	//신고 구분
}
