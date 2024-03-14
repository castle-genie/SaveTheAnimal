package com.spring.application.vo;

import lombok.Data;

@Data
public class ApplicationVO {
	private int applicationId;			// 신청 ID
	private String applicationDate;		// 신청 날짜
	private String applicationComment;	// 신청 다짐
	private int applicationResult;		// 봉사 결과
	private String userId;				// 유저 아이디
	private int volunteerId;			// 봉사 공고 아이디
}
