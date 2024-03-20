package com.spring.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.comment.service.FcommentService;
import com.spring.comment.vo.FcommentVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/fcomment")
@Slf4j
public class FcommentController {
	
	@Setter(onMethod_ = @Autowired)
	private FcommentService fcommentService;

	@GetMapping(value = "/all/{fboardId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FcommentVO> replyList(@PathVariable("fboardId") Integer fboardId, FcommentVO fcommentvo) {
		log.info("ReplyList 호출");
		
		List<FcommentVO> fcommentlist = null;
		fcommentlist = fcommentService.fcommentList(fcommentvo);
		return fcommentlist;
	}
	
/**************************************************************
* 댓글 글쓰기 구현하기
* @return String
* 참고 : @RequestBody: JSON 데이터를 원하는 타입으로 바인딩 처리한다.{name:value} 
* 		consumes 속성을 이용하면 사용자가 Request Body에 담는 타입을 제한할 수 있으며 
* 		만약 요청 데이터가 JSON이라면 요청시 헤더에 반드시 application/json이 존재해야 한다.
* 
* 		produces 속성을 추가하고 dataType을 지정하면 해당 데이터타입으로만 
* 		사용자에게 응답하겠다는 의미로 해석하면 된다.
* 현재 요청 URL : http://localhost:8080/replies/replyInsert
**************************************************************/	
	
	@PostMapping(value = "replyInsert", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public String replyInsert(@RequestBody FcommentVO fcommentvo) {
		log.info("replyInsert 호출 성공");
		log.info("FcommentVO : " + fcommentvo);
		int result = 0;
		
		result = fcommentService.fcommentInsert(fcommentvo);
		return(result==1) ? "SUCCESS":"FAILURE";
	}
	
	@DeleteMapping(value = "/{replyNumber}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String replyDelete(@PathVariable("replyNumber") int replyNumber, FcommentVO fcommentvo) {
		fcommentvo.setFcommentId(replyNumber);
		int result = fcommentService.fcommentDelete(fcommentvo);
		return(result==1)?"SUCCESS":"FAILURE";
	}
	
	@PutMapping(value = "/{replyNumber}",
			consumes = "application/json",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String replyUpdate(@PathVariable("replyNumber") int replyNumber, @RequestBody FcommentVO fcommentvo) {
		fcommentvo.setFcommentId(replyNumber);
		int result = fcommentService.fcommentUpdate(fcommentvo);
		return(result==1)?"SUCCESS":"FAILURE";
	}
}
