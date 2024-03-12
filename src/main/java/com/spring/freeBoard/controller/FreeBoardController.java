package com.spring.freeBoard.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.freeBoard.service.FreeBoardService;
import com.spring.freeBoard.vo.FreeBoardVO;



@RequestMapping(value="/freeBoard/*")
@Controller
public class FreeBoardController {
	
	
	@Autowired
	public FreeBoardService freeBoardService;
	/*
	@GetMapping("freeBoardList")
	public String freeBoardList(Model model) throws Exception{
		List<FreeBoardVO> list = freeBoardService.freeBoardList();
		model.addAttribute("list", list);
		return "board/freeBoardList";
		
	}
	*/
	
	@GetMapping(value="list")
	public String freeBoardList(@ModelAttribute FreeBoardVO freeBoardVO, Model model) {
		List<FreeBoardVO> freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		model.addAttribute("freeBoardList", freeBoardList);
		
		return "board/freeBoardList";
	}
	
}
