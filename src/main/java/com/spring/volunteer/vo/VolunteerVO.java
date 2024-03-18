package com.spring.volunteer.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class VolunteerVO {
	private int volunteerId;			// 봉사 고유 번호
	private String volunteerDetail;		// 봉사활동 상세 정보
	private String volunteerDate;			// 봉사활동 등록일자
	private String volunteerTitle;		// 봉사활동 게시물 제목
	private int volunteerCnt;			// 봉사활동 게시물 조회수
	private String volunteerTime;		// 봉사활동 시행일
	private String volunteerDue;		// 봉사활동 신청 마감일
	private int volunteerLimit;			// 봉사활동 제한 인원수
	private String volunteerCost;		// 봉사활동 비용
	private String volunteerLocation;	// 봉사활동 장소
	private int volunteerProgress;		// 봉사활동 게시물 현재 정보
}
