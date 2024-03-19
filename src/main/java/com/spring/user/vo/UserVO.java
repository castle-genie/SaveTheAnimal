package com.spring.user.vo;

import java.sql.Date;

import lombok.Data;

/** UserVO 클래스 **/
@Data
public class UserVO {
	private String userId 		= ""; 
	private String userPasswd 	= "";
	private String userName		= "";
	private String userPhone	= "";
	private String userEmail 	= "";
	private Date userDate;
	private int userAct=0; 		
	private int userRepcnt=0; 		
	private int userVolcnt=0; 		
	private int userLevel=0; 		
	private int userAdoptChk=0;	
}
