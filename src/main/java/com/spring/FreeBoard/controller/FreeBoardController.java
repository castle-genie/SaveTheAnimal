package com.spring.FreeBoard.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.FreeBoard.service.FreeBoardService;
import com.spring.FreeBoard.vo.FreeBoardVO;
import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequestMapping("/board/*")
@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@Autowired
	private FcommentService fcommentService;
	

	@GetMapping(value = "freeBoardList")
	public String freeBoardList(FreeBoardVO freeBoardVO, Model model) {
		List<FreeBoardVO> freeBoardList = freeBoardService.freeBoardList(freeBoardVO);
		model.addAttribute("freeBoardList", freeBoardList);
		
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
	public String freeBoardDetail(Model model, @RequestParam("fboardId")int fboardId) {
		model.addAttribute("freeBoard", freeBoardService.freeBoardDetail(fboardId));
		
		
		//조회수 +1
		freeBoardService.plusCnt(fboardId);
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
	public String modify(@RequestParam("fboardId")int fboardId, Model model) {
		model.addAttribute("freeBoard", freeBoardService.freeBoardDetail(fboardId));
		return "board/freeBoardModify";
	}
	
	@PostMapping(value = "freeBoardModify")
	public String modify(FreeBoardVO freeBoardVO) {
		freeBoardService.updateFreeBoard(freeBoardVO);
		return "redirect:/board/freeBoardDetail?fboardId="+freeBoardVO.getFboardId();
	}
	
	//게시글 삭제
	@GetMapping(value = "delete")
	//@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@RequestParam("fboardId")int fboardId){
		freeBoardService.freeBoardDelete(fboardId);
		return "redirect:/board/freeBoardList";
	}
	
	
	
	
	/*
	@GetMapping(value = "freeBaordDetail")
	public String freeBoardDetail(FreeBoardVO freeBoardVO, Model model) {
		FreeBoardVO freeBoardDetail = freeBoardService.freeBoardDetail(freeBoardVO);
		model.addAttribute("freeBoardDetail", freeBoardDetail);
		
		return "board/freeBoardDetail";
	}
	*/
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
