package com.spring.volunteer.service;

import java.util.List;

import com.spring.volunteer.vo.VolunteerVO;

public interface VolunteerService {
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO);
}
