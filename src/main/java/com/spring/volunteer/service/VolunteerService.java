package com.spring.volunteer.service;

import java.util.List;

import com.spring.volunteer.vo.VolunteerVO;

public interface VolunteerService {
	/* users */
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO);
	
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO);
	
	
	/* admin */
	public int volunteerInsert(VolunteerVO volunteerVO) throws Exception;
	
	public VolunteerVO volunteerUpdateForm(VolunteerVO volunteerVO);
	
	public int volunteerUpdate(VolunteerVO volunteerVO) throws Exception;
	
	public int volunteerDelete(VolunteerVO volunteerVO) throws Exception;;
}
