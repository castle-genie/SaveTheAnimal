package com.spring.donate.dao;

import java.util.List;

import com.spring.donate.vo.DonateVO;

public interface DonateDAO {
	List<DonateVO> donateList (DonateVO dovo);
}
