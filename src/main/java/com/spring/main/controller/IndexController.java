package com.spring.main.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/*")
@Controller
@Slf4j
public class IndexController {
	@GetMapping("/")
	public String mainpage() {		
		return "project/mainpage";
	}		
	
	@GetMapping("admin")
	public String adminLogin() {
		return "admin/adminLogin";
	}	
	
	@GetMapping("/randomImages")
    @ResponseBody
    public List<String> getRandomImages(Model model) {
        // 이미지 파일이 있는 디렉토리 경로
        String imageDirectoryPath = "/images/storage/volunteer";
        System.out.println(imageDirectoryPath);
        // 디렉토리에서 이미지 파일 목록을 가져옴
        File imageDirectory = new File(imageDirectoryPath);
        System.out.println(imageDirectory);
        File[] imageFiles = imageDirectory.listFiles();
        // 이미지 파일 경로를 저장할 리스트
        List<String> imagePaths = new ArrayList<>();
        // 랜덤하게 4개의 이미지 파일 선택
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            File randomImageFile = imageFiles[random.nextInt(imageFiles.length)];
            imagePaths.add(randomImageFile.getPath());
        }
        log.info("이미지 " + imagePaths.toString());
        // 선택된 이미지 파일의 경로 리스트 반환
        return imagePaths;
    }
}