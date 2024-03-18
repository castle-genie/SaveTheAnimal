package com.spring.counseling.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CounselingRequestVO {
    private Date counselingSchedule; // 예약 일정
    private String userId; // 회원 ID
    private String counselingJudgment; // 적격 판정
    private String counselingDetail; // 상담 내용
    private String counselingName; // 성명
    private int counselingAge; // 연령
    private String counselingAddress; // 주소
    private String counselingJob; // 직업
    private int counselingAdopt; // 입양/임시보호 구분
}

