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
}
