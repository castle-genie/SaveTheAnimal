package com.spring.counseling.controller;

import com.spring.admin.login.vo.AdminLoginVO;
import com.spring.counseling.service.CounselingService;
import com.spring.counseling.vo.CounselingVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequestMapping("/counseling")
@Controller
public class CounselingController {

    private static final String REDIRECT_ADMIN_COUNSELING_LIST = "redirect:/counseling/adminCounselingList";

    private static final String ADMIN_COUNSELING_DETAIL = "/admin/counseling/adminCounselingDetail";
    private static final String COUNSELING_UPDATE_FORM = "/admin/counseling/counselingUpdateForm";
    private static final String COUNSELING_DETAIL = "/counseling/counselingDetail";

    @Autowired
    private CounselingService service;

    /* users */

    @GetMapping("/counselingList")
    public String counselingList(CounselingVO counselingVO, Model model) {
        List<CounselingVO> counselingList = service.counselingList(counselingVO);
        model.addAttribute("counselingList", counselingList);
        return "/counseling/counselingList";
    }

    @GetMapping("/counselingDetail")
    public String counselingDetail(@RequestParam("counselingId") int counselingId, Model model) {
        CounselingVO counselingVO = new CounselingVO();
        counselingVO.setCounselingId(counselingId);
        CounselingVO counselingDetail = service.counselingDetail(counselingVO);
        model.addAttribute("counselingDetail", counselingDetail);
        return "/counseling/counselingDetail"; // 상담 상세 페이지로 이동
    }

    /* admin */


    @GetMapping("/adminCounselingList")
    public String adminCounselingList(@SessionAttribute(name = "adminLogin", required = false) AdminLoginVO adminLoginVO, CounselingVO counselingVO, Model model) {
        // log.info("adminCounselingList 호출");
        if(adminLoginVO == null) {
            return "/admin/adminLogin";
        } else {
            List<CounselingVO> counselingList = service.counselingList(counselingVO);
            model.addAttribute("counselingList", counselingList);
            return "admin/counseling/adminCounselingList";
        }
    }

    @GetMapping("/counselingWriteForm")
    public String counselingWriteForm() {
        return "/counseling/counselingWriteForm";
    }

    @PostMapping("/counselingInsert")
    public String counselingInsert(CounselingVO counselingVO, RedirectAttributes ras) {
        try {
            int result = service.counselingInsert(counselingVO);
            if (result == 1) {
                return REDIRECT_ADMIN_COUNSELING_LIST;
            }
            ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요.");
        } catch (Exception e) {
            log.error("Error occurred while inserting counseling: {}", e.getMessage());
            ras.addFlashAttribute("errorMsg", "상담 공고 입력 중 오류가 발생했습니다.");
        }
        return "redirect:/counseling/counselingWriteForm";
    }


    @GetMapping("/adminCounselingDetail")
    public String adminCounselingDetail(@SessionAttribute(name = "adminLogin", required = false) AdminLoginVO adminLoginVO,
                                        @RequestParam(name = "counselingId") int counselingId,
                                        Model model) {
        // log.info("adminCounselingList 호출");
        if(adminLoginVO == null) {
            return "/admin/adminLogin";
        } else {
            CounselingVO counselingVO = new CounselingVO();
            counselingVO.setCounselingId(counselingId);
            CounselingVO counselingDetail = service.counselingDetail(counselingVO);
            model.addAttribute("CounselingDetail", counselingDetail);
            return "admin/counseling/adminCounselingDetail";
        }
    }







    @GetMapping("/counselingUpdateForm")
    public String counselingUpdateForm(@RequestParam("counselingId") CounselingVO counselingId, Model model) {
        CounselingVO counselingUpdateForm = service.counselingUpdateForm(counselingId);
        model.addAttribute("updateList", counselingUpdateForm);
        return COUNSELING_UPDATE_FORM;
    }

    @PostMapping("/counselingUpdate")
    public String counselingUpdate(CounselingVO counselingVO) {
        try {
            int result = service.counselingUpdate(counselingVO);
            if (result == 1) {
                return REDIRECT_ADMIN_COUNSELING_LIST;
            }
        } catch (Exception e) {
            log.error("Error occurred while updating counseling: {}", e.getMessage());
        }
        return "redirect:/counseling/counselingUpdateForm?counselingId=" + counselingVO.getCounselingId();
    }

    @GetMapping("/counselingDelete")
    public String counselingDelete(@RequestParam("counselingId") CounselingVO counselingId) {
        try {
            int result = service.counselingDelete(counselingId);
            if (result == 1) {
                return REDIRECT_ADMIN_COUNSELING_LIST;
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting counseling: {}", e.getMessage());
        }
        return REDIRECT_ADMIN_COUNSELING_LIST;
    }
}
