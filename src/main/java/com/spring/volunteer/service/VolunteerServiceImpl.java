package com.spring.volunteer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.volunteer.dao.VolunteerDAO;
import com.spring.volunteer.vo.VolunteerVO;

@Service
public class VolunteerServiceImpl implements VolunteerService {
	
	@Autowired
	private VolunteerDAO volunteerDAO;
	
	/* users */
	@Override
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO> volunteerList = volunteerDAO.volunteerList(volunteerVO);
		return volunteerList;
	}

	@Override
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO) {
		VolunteerVO volunteerDetail = null; 
		volunteerDetail = volunteerDAO.volunteerDetail(volunteerVO);
		if(volunteerDetail != null) {
			volunteerDetail.setVolunteerDetail(volunteerDetail.getVolunteerDetail().replaceAll("\n", "<br />"));
		}
		return volunteerDetail;
	}
	
	/* admin */
	@Override
	public int volunteerInsert(VolunteerVO volunteerVO) {
		int volunteerInsert = 0;
		volunteerInsert = volunteerDAO.volunteerInsert(volunteerVO);
		return volunteerInsert;
	}
	
	@Override
	public VolunteerVO volunteerUpdateForm(VolunteerVO volunteerVO) {
		VolunteerVO volunteerUpdateForm = null;
		volunteerUpdateForm = volunteerDAO.volunteerDetail(volunteerVO);
		if(volunteerUpdateForm != null) {
			volunteerUpdateForm.setVolunteerDetail(volunteerUpdateForm.getVolunteerDetail().replaceAll("<br />", "/n"));
		}
		return volunteerUpdateForm;
	}
	
	@Override
	public int volunteerUpdate(VolunteerVO volunteerVO) {
		int volunteerUpdate = volunteerDAO.volunteerUpdate(volunteerVO);
		return volunteerUpdate;
	}
	
	@Override
	public int volunteerDelete(VolunteerVO volunteerVO) {
		int volunteerDelete = 0;
		volunteerDelete = volunteerDAO.volunteerDelete(volunteerVO);
		return volunteerDelete;
	}
}
