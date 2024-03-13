package com.spring.freeBoard.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.freeBoard.service.FreeBoardService;
import com.spring.freeBoard.vo.FreeBoardVO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("/board/*")
@Controller
public class FreeBoardController {
	@Autowired
	private FreeBoardService freeBoardService;
	@GetMapping(value = "freeBoardList")
	public String freeBoardList(FreeBoardVO freeBoardVO, Model model) {
		List<FreeBoardVO> freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		model.addAttribute("freeBoardList", freeBoardList);
		
		return "board/freeBoardList";
	}
	
	@GetMapping(value = "freeBaordDetail")
	public String freeBoardDeteail(FreeBoardVO freeBoardVO, Model model) {
		FreeBoardVO freeBoardDetail = freeBoardService.freeBoardDetail(freeBoardVO);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		
		return "board/freeBoardDetail";
	}
	/*
	@ResponseBody
	@GetMapping(value = "/freeBoardList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FreeBoardVO> freeBoardList(FreeBoardVO freeBoardVO){
		List<FreeBoardVO> freeBoardList = null;
		freeBoardList = freeBoardservice.freeBoardList(freeBoardVO);
		//return "redirect:/board/freeBoardList";
		
		return freeBoardList;
	}
	*/
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
