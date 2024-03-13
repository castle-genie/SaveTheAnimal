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
	
	public int reportUpdate(ReportVO rvo);
	public int reportModify(ReportVO rvo);
	public int reportDelete(ReportVO rvo);
	
	
}
