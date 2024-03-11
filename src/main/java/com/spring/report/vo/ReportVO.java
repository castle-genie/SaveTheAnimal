package com.spring.report.vo;

import lombok.Data;

@Data
public class ReportVO {
	private int reportId			= 0;
	private int reportSort			= 0;
	private String reportDate;	
	private String reportDetail		= "";
	private int reportStatus;
	
	//모든 게시판 VO 파일 참조 필요
	private String userId			= "";
	private int fboardId			= 0;
	private int vfboardId			= 0;
	private int afboardId			= 0;
	private int fcommentId			= 0;
	private int vfcommentId			= 0;
	private int afcommentId			= 0;
	
	private String boardTitle;
	private String boardDate;
	private String boardUser;
	private String boardContent;
	private int boardId;
	
	
//	private String ftitle			= "";
//	private String vftitle			= "";
//	private String aftitle			= "";
//	
//	private String fuser			= "";
//	private String vfuser			= "";
//	private String afuser			= "";
//	private String fcouser			= "";
//	private String vfcouser			= "";
//	private String afcouser			= "";
//	
//	private String fdate;
//	private String vfdate;
//	private String afdate;
//	private String fcodate;
//	private String vfcodate;
//	private String afcodate;
//	
//	private String fcontent			= "";
//	private String vfcontent		= "";
//	private String afcontent		= "";
//	private String fcocontent		= "";
//	private String vfcocontent		= "";
//	private String afcocontent		= "";
	
}
