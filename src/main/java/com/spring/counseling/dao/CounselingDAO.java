package com.spring.counseling.dao;

import com.spring.counseling.vo.CounselingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    CounselingVO counselingDetail(int counselingVO);

    int counselingDelete(int counselingVO);

    CounselingVO getCounselingDetail(int counselingId);
}

