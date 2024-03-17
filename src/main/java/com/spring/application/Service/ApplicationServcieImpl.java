package com.spring.application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.application.dao.ApplicationDAO;
import com.spring.application.vo.ApplicationVO;
import com.spring.volunteer.vo.VolunteerVO;

@Service
public class ApplicationServcieImpl implements ApplicationService{
	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	public int applicationCount(ApplicationVO applicationVO) {
		int applicationCount = 0;
		applicationCount = applicationDAO.applicationCount(applicationVO);
		return applicationCount;
	}

	@Override
	public List<ApplicationVO> applicationList(ApplicationVO applicationVO) {
		List<ApplicationVO> applicationList = applicationDAO.applicationList(applicationVO);
		return applicationList;
	}
}
