package com.spring.application.Service;

import java.util.List;

import com.spring.application.vo.ApplicationVO;

public interface ApplicationService {
	public int applicationCount(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationList(ApplicationVO applicationVO);
	
	public int applicationSubmit(ApplicationVO applicationVO);
	
	public List<ApplicationVO> applicationView(ApplicationVO applicationVO);
}
