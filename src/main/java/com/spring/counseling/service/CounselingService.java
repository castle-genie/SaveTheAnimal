package com.spring.counseling.service;

import java.util.List;
import com.spring.counseling.vo.CounselingVO;
import com.spring.counseling.vo.SurveyRequestVO;

public interface CounselingService {
    List<CounselingVO> getAllCounselings();
    CounselingVO getCounselingDetail(CounselingVO counselingVO);
    int createCounseling(CounselingVO counselingVO);
    int submitSurvey(SurveyRequestVO surveyRequestVO); // 수정된 부분
}
