package com.spring.reort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.report.dao.ReportDao;
import com.spring.report.vo.ReportVO;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao rDao;
	
	
	@Override
	public List<ReportVO> reportList(ReportVO rvo) {
		List<ReportVO> list = null;
		list = rDao.reportList(rvo);
		return list;
	}

}
