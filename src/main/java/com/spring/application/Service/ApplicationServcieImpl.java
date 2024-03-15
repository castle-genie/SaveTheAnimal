package com.spring.application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.application.dao.ApplicationDAO;
import com.spring.application.vo.ApplicationVO;

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
}
