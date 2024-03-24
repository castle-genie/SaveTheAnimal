package com.spring.counseling.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.counseling.vo.CounselingVO;

@Mapper
public interface CounselingDAO {
    /* user */
    public List<CounselingVO> counselingList(CounselingVO counselingVO);

    public CounselingVO counselingDetail(CounselingVO counselingVO);

    /* admin */
    //public List<CounselingVO> counselingList(CounselingVO counselingVO); // user 쪽의 리스트와 동일ㄴ
    public int counselingInsert(CounselingVO counselingVO);

    public int counselingUpdate(CounselingVO counselingVO);

    public int counselingDelete(CounselingVO counselingVO);
}

