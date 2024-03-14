package com.spring.report.service;

import java.util.List;

import com.spring.report.vo.ReportVO;

public interface ReportService {

	public List<ReportVO> reportList(ReportVO rvo);
	public ReportVO reportDetail(ReportVO rvo);
	public int reportDelete(ReportVO rvo) throws Exception;
	public int reportModify(ReportVO rvo);
	
	public int reportInsertFB(ReportVO rvo) throws Exception;
	public int reportInsertVB(ReportVO rvo) throws Exception;
	public int reportInsertAB(ReportVO rvo) throws Exception;
	public int reportInsertFC(ReportVO rvo) throws Exception;
	public int reportInsertVC(ReportVO rvo) throws Exception;
	public int reportInsertAC(ReportVO rvo) throws Exception;
	
	public int reportUpdateFB(ReportVO rvo);
	public int reportUpdateVB(ReportVO rvo);
	public int reportUpdateAB(ReportVO rvo);
	public int reportUpdateFC(ReportVO rvo);
	public int reportUpdateVC(ReportVO rvo);
	public int reportUpdateAC(ReportVO rvo);

	
}
