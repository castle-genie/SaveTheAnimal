package com.spring.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.report.vo.ReportVO;

@Mapper
public interface ReportDao {
	public List<ReportVO> reportList(ReportVO rvo);
		
	
}
