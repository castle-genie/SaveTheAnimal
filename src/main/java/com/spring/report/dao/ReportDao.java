package com.spring.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.report.vo.ReportVO;

@Mapper
public interface ReportDao {
	public List<ReportVO> reportList(ReportVO rvo);
	public ReportVO reportDetail(ReportVO rvo);
	
	public int reportInsertFB(ReportVO rvo);
	public int reportInsertVB(ReportVO rvo);
	public int reportInsertAB(ReportVO rvo);
	public int reportInsertFC(ReportVO rvo);
	public int reportInsertVC(ReportVO rvo);
	public int reportInsertAC(ReportVO rvo);
	
	public int reportUpdateFB(ReportVO rvo);
	public int reportUpdateVB(ReportVO rvo);
	public int reportUpdateAB(ReportVO rvo);
	public int reportUpdateFC(ReportVO rvo);
	public int reportUpdateVC(ReportVO rvo);
	public int reportUpdateAC(ReportVO rvo);
	
	
	public int reportModify(ReportVO rvo);
	public int reportDelete(ReportVO rvo);
	
	
}
