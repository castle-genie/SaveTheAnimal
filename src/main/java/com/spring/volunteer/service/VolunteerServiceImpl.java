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

	@Override
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO> volunteerList = volunteerDAO.volunteerList(volunteerVO);
		return volunteerList;
	}

}
