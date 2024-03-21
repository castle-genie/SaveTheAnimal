package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comment")
@Slf4j
public class FcommentController {
	
	@Autowired
	private FcommentService fcommentService;
	
	@GetMapping(value = "/all/{fboardId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FcommentVO> fcommentList(@PathVariable("fboardId")int fboardId,FcommentVO fcommentvo){
		log.info("FcommentList 호출");
		
		List<FcommentVO> list = null;
		list = fcommentService.fcommentList(fcommentvo);
		return list;
	}

}
