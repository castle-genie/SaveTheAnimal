package com.spring.counseling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.counseling.dao.CounselingDAO;
import com.spring.counseling.vo.CounselingVO;
import com.spring.counseling.vo.SurveyRequestVO; // SurveyRequestVO를 import

@Service
public class CounselingServiceImpl implements CounselingService {

    @Autowired
    private CounselingDAO counselingDAO;

    @Override
    public List<CounselingVO> getAllCounselings() {
        return counselingDAO.getAllCounselings();
    }

    @Override
    public CounselingVO getCounselingDetail(CounselingVO counselingVO) {
        return counselingDAO.getCounselingDetail(counselingVO);
    }

    @Override
    public int createCounseling(CounselingVO counselingVO) {
        return counselingDAO.createCounseling(counselingVO);
    }

    // SurveyRequestVO를 받아와서 처리하는 submitSurvey 메서드 구현
    @Override
    public int submitSurvey(SurveyRequestVO surveyRequestVO) {
        // Survey 저장 로직 구현
        // 예: return counselingDAO.saveSurvey(surveyRequestVO);
        return 0; // 임시로 0을 반환하도록 구현
    }
}
