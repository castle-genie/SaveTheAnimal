package com.spring.volunteer.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.volunteer.vo.VolunteerVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class VolunteerDAOTests {
	@Autowired
	private VolunteerDAO volunteerDAO;
	
	/*
	@Test
	public void testVolunteerList() {
		VolunteerVO volunteerVO = new VolunteerVO();
		List<VolunteerVO> volunteerList = volunteerDAO.volunteerList(volunteerVO);
		for(VolunteerVO list : volunteerList) {
			log.info(list.toString());
		}
		log.info("전체 행 갯수 : " + volunteerDAO.volunteerList(volunteerVO));
	} */
	
	/* */
	@Test
	public void testVolulnteerDetail(){
		VolunteerVO volunteerVO = new VolunteerVO();
		volunteerVO.setVolunteerId(1);
		log.info("적용된 행 갯수: " + volunteerDAO.volunteerDetail(volunteerVO));
	}
}
