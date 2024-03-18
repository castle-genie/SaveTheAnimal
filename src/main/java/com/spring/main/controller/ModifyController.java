
  package com.spring.main.controller;
  
 import java.time.LocalDate; import java.util.ArrayList; import
 java.util.List;
 
 import org.springframework.stereotype.Controller; import
 org.springframework.ui.Model; import
 org.springframework.web.bind.annotation.GetMapping; import
 org.springframework.web.bind.annotation.RequestMapping;
  
 import lombok.extern.slf4j.Slf4j;
 
 @Controller
  
 @RequestMapping("/project/*")
  
 @Slf4j public class ModifyController {
  
  @GetMapping("/volunteer") public String showCalendar() { return
  "/project/volunteer"; } }
  
 