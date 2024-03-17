package com.spring.application.dao;

import java.util.List;

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
	
	/*
	@Test
	public void applicationCount() {
		ApplicationVO applicationVO  = new ApplicationVO();
		applicationVO.setVolunteerId(2);
		
		log.info("총 갯수 : " + applicationDAO.applicationCount(applicationVO));
	}*/
	
	@Test
	public void applicationList() {
	    ApplicationVO applicationVO = new ApplicationVO();
	    applicationVO.setVolunteerId(2); // volunteerId 설정
	    List<ApplicationVO> applicationList = applicationDAO.applicationList(applicationVO); // volunteerId가 설정된 applicationVO로 쿼리 실행
	    
	    if (applicationList != null) {
	        for(ApplicationVO list : applicationList) {
	            if (list != null) {
	                log.info(list.toString());
	            }
	        }
	        log.info("전체 행 갯수 : " + applicationDAO.applicationList(applicationVO)); // applicationList의 크기 출력
	    } else {
	        log.info("조회된 결과가 없습니다.");
	    }
	}
}
