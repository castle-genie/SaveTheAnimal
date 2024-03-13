package com.spring.freeBoard.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.freeBoard.service.FreeBoardService;
import com.spring.freeBoard.vo.FreeBoardVO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("/board/*")
@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@GetMapping(value = "/freeBoardList")
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = null;
		freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		return freeBoardList;
	}
	/*
	@ResponseBody
	@GetMapping(value = "freeBoardList")
	public String freeBoardList(FreeBoardVO freeBoardVO, Model model) {
		List<FreeBoardVO> freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		model.addAttribute("freeBoardList", freeBoardList);
		
		return "freeBoardList";
	}
	*/
	/*
	@GetMapping("freeBoardList")
	public String freeBoardList(Model model) throws Exception{
		List<FreeBoardVO> list = freeBoardService.freeBoardList();
		model.addAttribute("list", list);
		return "board/freeBoardList";
		
	}
	*/
}
