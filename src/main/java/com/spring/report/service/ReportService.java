package com.spring.report.service;

import java.util.List;

import com.spring.report.vo.ReportVO;

public interface ReportService {

	public List<ReportVO> reportList(ReportVO rvo);
	public ReportVO reportDetail(ReportVO rvo);
	public int reportUpdate(ReportVO rvo);
	
}