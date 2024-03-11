package com.spring.sanction.vo;

import com.spring.report.vo.ReportVO;

import lombok.Data;

@Data
public class SanctionVO {
	private int sanctionId;
	private int sanctionStatus;
	private int sanctionResult;
	private int sanctionDate;
	
	private String boardUser;
	private ReportVO rvo;
	
}
