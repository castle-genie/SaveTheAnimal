package com.spring.application.vo;

import com.spring.user.vo.UserVO;
import com.spring.volunteer.vo.VolunteerVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ApplicationVO extends UserVO{
	private int applicationId;			// 신청 ID
	private String applicationDate;		// 신청 날짜
	private String applicationComment;	// 신청 다짐
	private int applicationResult;		// 봉사 결과
	private String userId;				// 유저 아이디
	private int volunteerId;			// 봉사 공고 아이디
	private String userName;            // 유저 이름
	
	
	  // userName 필드를 설정하는 메서드
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
