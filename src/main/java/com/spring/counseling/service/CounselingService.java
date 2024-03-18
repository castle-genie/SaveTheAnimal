package com.spring.counseling.service;

import java.util.List;
import com.spring.counseling.vo.CounselingVO;

public interface CounselingService {
    List<CounselingVO> getAllCounselings();
    CounselingVO getCounselingDetail(CounselingVO counselingVO);
    int createCounseling(CounselingVO counselingVO);
}
