package com.spring.report.service;

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

	@Override
	public ReportVO reportDetail(ReportVO rvo) {
		ReportVO detail = rDao.reportDetail(rvo);
		if(detail != null) {
			detail.setReportDetail(detail.getReportDetail().replaceAll("\n", "<br />"));
		}
		
		return detail;
	}

	@Override
	public int reportDelete(ReportVO rvo) throws Exception {
		int result = rDao.reportDelete(rvo);
		return result;
		
	}

	@Override
	public int reportModify(ReportVO rvo) {
		int result = rDao.reportModify(rvo);
		return result;
	}


	@Override
	public int reportInsertFB(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertFB(rvo);
		return result;
	}
	@Override
	public int reportInsertVB(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertVB(rvo);
		return result;
	}
	@Override
	public int reportInsertAB(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertAB(rvo);
		return result;
	}
	@Override
	public int reportInsertFC(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertFC(rvo);
		return result;
	}
	@Override
	public int reportInsertVC(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertVC(rvo);
		return result;
	}
	@Override
	public int reportInsertAC(ReportVO rvo) throws Exception {
		int result = rDao.reportInsertAC(rvo);
		return result;
	}


	@Override
	public int reportUpdateFB(ReportVO rvo) {
		int result = rDao.reportUpdateFB(rvo);
		return result;
	}
	@Override
	public int reportUpdateVB(ReportVO rvo) {
		int result = rDao.reportUpdateVB(rvo);
		return result;
	}
	@Override
	public int reportUpdateAB(ReportVO rvo) {
		int result = rDao.reportUpdateAB(rvo);
		return result;
	}
	@Override
	public int reportUpdateFC(ReportVO rvo) {
		int result = rDao.reportUpdateFC(rvo);
		return result;
	}
	@Override
	public int reportUpdateVC(ReportVO rvo) {
		int result = rDao.reportUpdateVC(rvo);
		return result;
	}
	@Override
	public int reportUpdateAC(ReportVO rvo) {
		int result = rDao.reportUpdateAC(rvo);
		return result;
	}

	
	
}
