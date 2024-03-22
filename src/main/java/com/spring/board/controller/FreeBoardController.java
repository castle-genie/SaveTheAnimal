package com.spring.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.service.FreeBoardService;
import com.spring.board.vo.FreeBoardVO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("/board/*")
@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	

	@GetMapping(value = "freeBoardList")
	public String freeBoardList(FreeBoardVO freeBoardVO, Model model) {
		log.info("게시글불러오기");
		List<FreeBoardVO> freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		model.addAttribute("freeBoardList", freeBoardList);
		log.info("게시글불러오기완료");
		
		return "board/freeBoardList";
		
	}
	/*
	// 게시글 조회
	@GetMapping(value = "freeBoardDetail")
	public String freeBoardDetail(Model model, @RequestParam("fboardId")int fboardId) {
		model.addAttribute("freeBoard", freeBoardService.freeBoardDetail(fboardId));
		
		
		//조회수 +1
		freeBoardService.plusCnt(fboardId);
		
		return "board/freeBoardDetail";
		
		//댓글 조회
		List<FcommentVO> fcomment;
		fcomment = fcommenetService.list(fboardId);
		model.addAttribute("fcomment", fcomment);
		
		return "/comment/fcomment";
	}
	*/
	// 게시글 조회
	@GetMapping(value = "freeBoardDetail")
	public String freeBoardDetail(Model model, FreeBoardVO freeBoardVO){
		model.addAttribute("freeBoard", freeBoardService.freeBoardDetail(freeBoardVO));
		
		//조회수 +1
		freeBoardService.plusCnt(freeBoardVO);
		
		return "board/freeBoardDetail";
		
		/*
		//댓글 조회
		List<FcommentVO> fcommentList = fcommentService.list(fboardId);
		model.addAttribute("fcommentList", fcommentList);
		
		return "fcommentList";
		*/
		/*
		//댓글 조회
		List<FcommentVO> fcomment;
		fcomment = fcommentService.list(fboardId);
		model.addAttribute("fcomment", fcomment);
		
		return "/comment/fcomment";
		*/
	}
	
	//게시글 등록하는 페이지 접속
	@GetMapping(value = "freeBoardCreate")
	public String getCreate() throws Exception{
		return "board/freeBoardCreate";
	}
	
	//게시글 등록하기
	@PostMapping(value = "freeBoardCreate")
	public String freeBoardCreate(FreeBoardVO freeBoardVO){
		
		freeBoardService.insertFreeBoard(freeBoardVO);
		
		//return "redirect:/board/freeBoardDetail?fboardId=" + freeBoardVO.getFboardId();
		
		return "redirect:/board/freeBoardList";
	}
	//게시글 수정
	@GetMapping(value = "freeBoardModify")
	public String modify(FreeBoardVO freeBoardVO, Model model) {
		model.addAttribute("freeBoard", freeBoardService.freeBoardDetail(freeBoardVO));
		return "board/freeBoardModify";
	}
	
	@PostMapping(value = "freeBoardModify")
	public String modify(FreeBoardVO freeBoardVO) {
		log.info("수정");
		freeBoardService.updateFreeBoard(freeBoardVO);
		log.info("수정2");
		return "redirect:/board/freeBoardDetail?fboardId="+freeBoardVO.getFboardId();
	}
	
	//게시글 삭제
	@GetMapping(value = "delete")
	//@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(FreeBoardVO freeBoardVO){
		
		log.info("삭제" + freeBoardVO);
		freeBoardService.deleteFreeBoard(freeBoardVO);
		log.info("삭제완료");
		return "redirect:/board/freeBoardList";
	}
	
}