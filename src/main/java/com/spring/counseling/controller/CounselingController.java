package com.spring.counseling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.counseling.service.CounselingService;
import com.spring.counseling.vo.CounselingVO;
import com.spring.counseling.vo.SurveyRequestVO; // SurveyRequestVO import 추가

@Controller
public class CounselingController {

    @Autowired
    private CounselingService counselingService;

    // 상담 리스트 조회 요청 처리
    @GetMapping("/counselingList")
    public String getCounselingList(Model model) {
        // 모든 상담 정보를 가져옴
        List<CounselingVO> counselingList = counselingService.getAllCounselings();
        // Model에 상담 리스트 추가
        model.addAttribute("counselingList", counselingList);
        // 상담 리스트 페이지 반환
        return "counseling/counselingList";
    }

    // 상담 상세 정보 조회 요청 처리
    @GetMapping("/counselingDetail")
    public String getCounselingDetail(CounselingVO counselingVO, Model model) {
        // 상세 정보를 조회하여 모델에 추가
        CounselingVO detail = counselingService.getCounselingDetail(counselingVO);
        model.addAttribute("counselingDetail", detail);
        // 상담 상세 페이지 반환
        return "counseling/counselingDetail";
    }

    // 상담 신청 요청 처리
    @PostMapping("/counseling/create")
    public String createCounseling(CounselingVO counselingVO, SurveyRequestVO surveyRequestVO) {
        // 상담 정보 생성
        int counselingId = counselingService.createCounseling(counselingVO);
        // 설문 정보 생성
        //surveyService.createSurvey(counselingId, surveyRequestVO); // SurveyService 필요
        // 상담 완료 페이지로 이동
        return "counseling/counselingComplete"; // 상담 완료 페이지의 경로에 따라 수정해야 함
    }
}
