package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.board.service.NoticeBoardService;
import com.spring.board.vo.NoticeBoardVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/noticeBoard/*")
@Controller
public class NoticeBoardController {
	@Autowired
	private NoticeBoardService noticeBoardService;
	
	

	@GetMapping(value = "noticeBoardList")
	public String noticeBoardList(NoticeBoardVO nvo, Model model) {
		log.info("공지게시글불러오기");
		List<NoticeBoardVO> noticeBoardList = noticeBoardService.noticeBoardList(nvo);
		model.addAttribute("noticeBoardList", noticeBoardList);
		log.info("공지게시글불러오기완료");
		
		return "board/noticeBoardList";
		
	}
	
	// 게시글 조회
	@GetMapping(value = "noticeBoardDetail")
	public String noticeBoardDetail(Model model, NoticeBoardVO nvo){
		model.addAttribute("noticeBoard", noticeBoardService.noticeBoardDetail(nvo));
		
		//조회수 +1
		noticeBoardService.plusCnt(nvo);
		
		return "board/noticeBoardDetail";
	}
	
	//게시글 등록하는 페이지 접속
	@GetMapping(value = "noticeBoardCreate")
	public String getCreate() throws Exception{
		return "board/noticeBoardCreate";
	}
	
	//게시글 등록하기
	@PostMapping(value = "noticeBoardCreate")
	public String noticeBoardCreate(NoticeBoardVO nvo){
		
		noticeBoardService.insertNoticeBoard(nvo);
		
		
		return "redirect:/noticeBoard/noticeBoardList";
	}
	
	//게시글 수정
	@GetMapping(value = "noticeBoardModify")
	public String modify(NoticeBoardVO nvo, Model model) {
		model.addAttribute("noticeBoard", noticeBoardService.noticeBoardDetail(nvo));
		return "board/noticeBoardModify";
	}
	
	@PostMapping(value = "noticeBoardModify")
	public String modify(NoticeBoardVO nvo) {
		log.info("수정");
		noticeBoardService.updateNoticeBoard(nvo);
		log.info("수정2");
		return "redirect:/noticeBoard/noticeBoardDetail?fboardId="+nvo.getNboardId();
	}
	
	//게시글 삭제
	@GetMapping(value = "delete")
	public String delete(NoticeBoardVO nvo){
		log.info("삭제" + nvo);
		noticeBoardService.deleteNoticeBoard(nvo);
		log.info("삭제완료");
		return "redirect:/noticeBoard/noticeBoardList";
	}

}
