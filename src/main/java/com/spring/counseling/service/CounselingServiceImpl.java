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
}
