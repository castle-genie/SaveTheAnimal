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
		volunteerVO.setVolunteerId(9);
		log.info("적용된 행 갯수: " + volunteerDAO.volunteerDetail(volunteerVO));
	}
	
	/*
	@Test
	public void testVolunteerInsert() {
		VolunteerVO volunteerVO = new VolunteerVO();
		volunteerVO.setVolunteerTitle("보령 카라두잉");
		volunteerVO.setVolunteerDetail("일하러 오세요");
		volunteerVO.setVolunteerTime("TO_DATE('2024-03-29', 'YYYY-MM-DD')");
		volunteerVO.setVolunteerDue("TO_DATE('2024-03-25 18:00', 'YYYY-MM-DD HH24:MI')");
		volunteerVO.setVolunteerLimit(5);
		volunteerVO.setVolunteerLocation("망우로 12라길 27");
		volunteerVO.setVolunteerCost("");
		log.info("적용된 행 갯수 : " + volunteerDAO.volunteerInsert(volunteerVO));
	}*/
	
	/* 
	@Test
	public void testVolunteerUpdate() {
		VolunteerVO volunteerVO = new VolunteerVO();
		volunteerVO.setVolunteerTitle("봉사 1");
		volunteerVO.setVolunteerDetail("수정후");
		volunteerVO.setVolunteerTime("2024-03-22");
		volunteerVO.setVolunteerDue("2024-03-11T18:00");
		volunteerVO.setVolunteerLimit(3);
		volunteerVO.setVolunteerLocation("망우로 12라길 27");
		volunteerVO.setVolunteerCost("");
		volunteerVO.setVolunteerId(4);
		log.info("적용된 행 갯수 : " + volunteerDAO.volunteerUpdate(volunteerVO));
	}*/
	
	/* 
	@Test
	public void testVolunteerDelete() {
		VolunteerVO volunteerVO = new VolunteerVO();
		volunteerVO.setVolunteerId(7);
		log.info("적용된 행 갯수 : " + volunteerDAO.volunteerDelete(volunteerVO));
	}*/
}
