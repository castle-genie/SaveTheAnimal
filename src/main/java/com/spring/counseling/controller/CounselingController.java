package com.spring.counseling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.counseling.service.CounselingService;
import com.spring.counseling.vo.CounselingVO;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CounselingController {

    @Autowired
    private CounselingService counselingService;

//    @Autowired
//    private SurveyService surveyService;

    @GetMapping("/counselingList")
    public String getCounselingList(Model model) {
        List<CounselingVO> counselingList = counselingService.getAllCounselings();
        model.addAttribute("counselingList", counselingList);
        return "counseling/counselingList";
    }

    @GetMapping("/counselingDetail")
    public CounselingVO getCounselingDetail(CounselingVO counselingVO, Model model) {
        return counselingService.getCounselingDetail(counselingVO);
    }

//    @PostMapping("/counseling/create")
//    public void createCounseling(CounselingVO counselingVO, SurveyVO surveyVo) {
//        int counselingId = counselingService.createCounseling(counselingVO);
//        surveyServicey.createSurvey(counselingId, surveyVo);
//    }
}
