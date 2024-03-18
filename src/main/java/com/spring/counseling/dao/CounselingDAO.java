package com.spring.counseling.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.counseling.vo.CounselingVO;

@Mapper
public interface CounselingDAO {
    List<CounselingVO> getAllCounselings();
    CounselingVO getCounselingDetail(CounselingVO counselingVO);

    int createCounseling(CounselingVO counselingVO);
}
