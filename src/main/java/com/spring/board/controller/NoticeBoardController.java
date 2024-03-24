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
@RequestMapping("/")
@Controller
public class NoticeBoardController {
	@Autowired
	private NoticeBoardService noticeBoardService;

	//////////////////// 유저 페이지
	// 공지게시판 글 목록(유저 페이지)
	@GetMapping("/noticeBoard/noticeBoardList")
	public String noticeBoardList(NoticeBoardVO nvo, Model model) {
		log.info("공지게시글불러오기");
		List<NoticeBoardVO> noticeBoardList = noticeBoardService.noticeBoardList(nvo);
		model.addAttribute("noticeBoardList", noticeBoardList);
		log.info("공지게시글불러오기완료");

		return "board/noticeBoardList";

	}

	// 공지게시판 글 상세보기(유저페이지)
	@GetMapping("/noticeBoard/noticeBoardDetail")
	public String noticeBoardDetail(Model model, NoticeBoardVO nvo) {
		model.addAttribute("noticeBoard", noticeBoardService.noticeBoardDetail(nvo));

		// 조회수 +1
		noticeBoardService.plusCnt(nvo);

		return "board/noticeBoardDetail";
	}
	
	//////////////////관리자 페이지

	// 공지게시판 글 목록(관리자 페이지)
	@GetMapping("/admin/noticeBoardList")
	public String adminNoticeBoardList(NoticeBoardVO nvo, Model model) {
		log.info("공지게시글불러오기");
		List<NoticeBoardVO> adminNoticeBoardList = noticeBoardService.noticeBoardList(nvo);
		model.addAttribute("noticeBoardList", adminNoticeBoardList);
		log.info("공지게시글불러오기완료");

		return "admin/board/noticeBoardList";

	}
	// 공지게시판 글 상세보기(관리자 페이지)
	@GetMapping("/admin/noticeBoardDetail")
	public String adminNoticeBoardDetail(Model model, NoticeBoardVO nvo) {
		log.info("관리자페이지 상세보기");
		model.addAttribute("noticeBoard", noticeBoardService.adminNoticeBoardDetail(nvo));
		log.info("관리자페이지 상세보기 완료");
		
		return "/admin/board/noticeBoardDetail";
	}

	// 게시글 등록하는 페이지 접속(관리자 페이지)
	@GetMapping("/admin/noticeBoardCreate")
	public String getCreate() throws Exception {
		return "admin/board/noticeBoardCreate";
	}

	// 게시글 등록하기(관리자 페이지)
	@PostMapping("/admin/board/noticeBoardCreate")
	public String noticeBoardCreate(NoticeBoardVO nvo) {

		noticeBoardService.insertNoticeBoard(nvo);

		return "redirect:/admin/noticeBoardList";
	}

	// 게시글 수정(관리자 페이지)
	@GetMapping("/admin/board/noticeBoardModify")
	public String modify(NoticeBoardVO nvo, Model model) {
		model.addAttribute("noticeBoard", noticeBoardService.noticeBoardDetail(nvo));
		return "admin/board/noticeBoardModify";
	}

	@PostMapping("/admin/board/noticeBoardModify")
	public String modify(NoticeBoardVO nvo) {
		log.info("수정");
		noticeBoardService.updateNoticeBoard(nvo);
		log.info("수정2");
		return "redirect:/admin/noticeBoardDetail?fboardId=" + nvo.getNboardId();
	}

	// 게시글 삭제
	@GetMapping("/admin/delete")
	public String delete(NoticeBoardVO nvo) {
		log.info("삭제" + nvo);
		noticeBoardService.deleteNoticeBoard(nvo);
		log.info("삭제완료");
		return "redirect:/admin/noticeBoardList";
	}

}
