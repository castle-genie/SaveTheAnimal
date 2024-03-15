package com.spring.application.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.application.vo.ApplicationVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ApplicatoinDAOTests {
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Test
	public void applicationCount() {
		ApplicationVO applicationVO  = new ApplicationVO();
		applicationVO.setVolunteerId(2);
		
		log.info("총 갯수 : " + applicationDAO.applicationCount(applicationVO));
	}
}
