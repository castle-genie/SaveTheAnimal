package com.spring.counseling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.counseling.dao.CounselingDAO;
import com.spring.counseling.vo.CounselingVO;

@Service
public class CounselingServiceImpl implements CounselingService {

    @Autowired
    private CounselingDAO counselingDAO;

    @Override
    public List<CounselingVO> counselingList(CounselingVO counselingVO) {
        return counselingDAO.counselingList(counselingVO);
    }

    @Override
    public CounselingVO counselingDetail(CounselingVO counselingVO) {
        return counselingDAO.counselingDetail(counselingVO);
    }

    @Override
    public int counselingInsert(CounselingVO counselingVO) throws Exception {
        return counselingDAO.counselingInsert(counselingVO);
    }

    @Override
    public CounselingVO counselingUpdateForm(CounselingVO counselingVO) {
        return counselingDAO.counselingDetail(counselingVO);
    }

    @Override
    public int counselingUpdate(CounselingVO counselingVO) throws Exception {
        return counselingDAO.counselingUpdate(counselingVO);
    }

    @Override
    public int counselingDelete(CounselingVO counselingVO) throws Exception {
        return counselingDAO.counselingDelete(counselingVO);
    }
}
