package com.spring.counseling.service;

import com.spring.counseling.vo.CounselingVO;

import java.util.List;

public interface CounselingService {
    List<CounselingVO> counselingList(CounselingVO counselingVO);
    CounselingVO counselingDetail(CounselingVO counselingVO);
    int counselingInsert(CounselingVO counselingVO) throws Exception;
    CounselingVO counselingUpdateForm(CounselingVO counselingVO);
    int counselingUpdate(CounselingVO counselingVO) throws Exception;
    int counselingDelete(CounselingVO counselingVO) throws Exception;
}
