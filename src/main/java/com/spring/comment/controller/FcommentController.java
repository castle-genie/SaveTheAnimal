package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/comment*")
public class FcommentController {
	
	@Autowired
	private FcommentService fcommentService;
	
	// 댓글 입력
	@RequestMapping("insert.do")
	public void insert(@ModelAttribute FcommentVO vo, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		fcommentService.create(vo);
	}
	
	//	댓글 목록(@Controller방식 : view를 리턴)
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int fboardId, ModelAndView mav) {
		List<FcommentVO> list = fcommentService.list(fboardId);
		// 뷰이름 지정
		mav.setViewName("board/replyList");
		// 뷰에 전달할 데이터 지정
		mav.addObject("list", list);
		// replyList.jsp로 포워딩
		return mav;
	}
	
	@RequestMapping("listJson.do")
	@ResponseBody
	public List<FcommentVO> listJson(@RequestParam int fboardId){
		List<FcommentVO> list = fcommentService.list(fboardId);
		return list;
	}
	
	

}
