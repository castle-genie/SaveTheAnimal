package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

@RestController
@RequestMapping("/comment/fcomment/*")
public class FcommentController {
	
	@Autowired
	private FcommentService fcommentService;
	
	//댓글 조회
	public void getView(@RequestParam("fboardId")int fboardId, Model model) throws Exception{
		List<FcommentVO> fcomment = null;
		fcomment = fcommentService.list(fboardId);
		model.addAttribute("focmment", fcomment);
	}
	//댓글 작성
	
	//댓글 수정
	
	//댓글 삭제
	
	

}
