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

    @Autowired
    private CounselingService counselingService;

    /* users */

    @GetMapping("/counselingList")
    public String counselingList(CounselingVO counselingVO, Model model) {
        List<CounselingVO> counselingList = counselingService.counselingList(counselingVO);
        model.addAttribute("counselingList", counselingList);
        return "/counseling/counselingList";
    }

    @GetMapping("/counselingDetail")
    public String counselingDetail(@RequestParam("counselingId") int counselingId, Model model) {
        CounselingVO counselingDetail = counselingService.counselingDetail(counselingId);
        model.addAttribute("counselingDetail", counselingDetail);
        return "/counseling/counselingDetail";
    }

    @GetMapping("/counselingWriteForm")
    public String counselingWriteForm(@RequestParam("animalId") int animalId, Model model) {
    	model.addAttribute("animalId", animalId);
        return "/counseling/counselingWriteForm";
    }

    @PostMapping("/counselingInsert")
    public String counselingInsert(CounselingVO counselingVO, RedirectAttributes ras) {
        try {
            int result = counselingService.counselingInsert(counselingVO);
            if (result == 1) {
                return "redirect:/counseling/counselingList";
            }
            ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요.");
        } catch (Exception e) {
            log.error("Error occurred while inserting counseling: {}", e.getMessage());
            ras.addFlashAttribute("errorMsg", "상담 입력 중 오류가 발생했습니다.");
        }
        return "redirect:/counseling/counselingWriteForm";
    }

    @PostMapping("/counselingDelete")
    public String counselingDelete(@RequestParam("counselingId") int counselingId) {
        try {
            int result = counselingService.counselingDelete(counselingId);
            if (result == 1) {
                return "redirect:/counseling/counselingList";
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting counseling: {}", e.getMessage());
        }
        return "redirect:/counseling/counselingList";
    }

    /* admin */

    @GetMapping("/adminCounselingList")
    public String adminCounselingList(@SessionAttribute(name = "adminLogin", required = false) AdminLoginVO adminLoginVO, CounselingVO counselingVO, Model model) {
        if (adminLoginVO == null) {
            return "/admin/adminLogin";
        } else {
            List<CounselingVO> counselingList = counselingService.counselingList(counselingVO);
            model.addAttribute("admincounselingList", counselingList);
            return "/admin/counseling/adminCounselingList"; // 여기 경로 수정 (/counseling/adminCounselingList)
        }
    }

    @GetMapping("/adminCounselingDetail")
    public String adminCounselingDetail(@SessionAttribute(name = "adminLogin", required = false) AdminLoginVO adminLoginVO,
                                        @RequestParam(name = "counselingId") int counselingId,
                                        Model model) {
        if (adminLoginVO == null) {
            return "/admin/adminLogin";
        } else {
            CounselingVO counselingDetail = counselingService.getCounselingDetail(counselingId);
            //List<CounselingVO> adminCounselingList = counselingService.counselingList(new CounselingVO()); // 해당 코드로 admincounselingList를 가져옵니다.
            model.addAttribute("adminCounselingDetail", counselingDetail);
            //model.addAttribute("admincounselingList", adminCounselingList); // admincounselingList를 모델에 추가합니다.
            return "/admin/counseling/adminCounselingDetail";
        }
    }



    @PostMapping("/admincounselingUpdate")
    public String counselingUpdate(CounselingVO counselingVO) {
        try {
            int result = counselingService.counselingUpdate(counselingVO);
            if (result == 1) {
                return "redirect:/counseling/adminCounselingList";
            }
        } catch (Exception e) {
            log.error("Error occurred while updating counseling: {}", e.getMessage());
        }
        return "redirect:/counseling/admincounselingUpdateForm?counselingId=" + counselingVO.getCounselingId();
    }

    @PostMapping("/admincounselingDelete")
    public String admincounselingDelete(@RequestParam("counselingId") int counselingId) {
        try {
            int result = counselingService.admincounselingDelete(counselingId);
            if (result == 1) {
                return "redirect:/counseling/adminCounselingList";
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting counseling: {}", e.getMessage());
        }
        return "redirect:/counseling/adminCounselingList";
    }

}
