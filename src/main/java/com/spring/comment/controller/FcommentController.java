package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

@RestController
@RequestMapping("/comment/*")
public class FcommentController {
	
	@Autowired
	private FcommentService fcommentService;
	
	/*
	@PostMapping(value = "fcomment")
	public int insertComment(@RequestBody FcommentVO fcommentvo) {
		int result = fcommentService.FcommentInsert(fcommentvo);
		return result;
	}
	*/
	
	//댓글 조회
	
	
	//댓글 작성
	
	//댓글 수정
	
	//댓글 삭제
	
	

}
