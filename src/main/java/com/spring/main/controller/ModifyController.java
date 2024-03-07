package com.spring.main.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/project/*")
@Slf4j
public class ModifyController {
	@GetMapping("/volunteer")
	public String showCalendar(Model model) {
		List<List<Integer>> calendar = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2024, 1, 1); // 2024년 1월 1일로 설정
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);

        // 해당 연도가 윤년인지 확인하여 2월의 마지막 날짜 설정
        int daysInFebruary = firstDayOfMonth.isLeapYear() ? 29 : 28;

        int currentDay = 1;

        // Create calendar matrix
        while (currentDay <= 365) { // 2024년은 윤년이므로 2월이 29일까지이기 때문에 365가 아니라 366
            List<Integer> week = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                if (currentDay <= 366 && (i >= firstDayOfMonth.getDayOfWeek().getValue() - 1 || week.size() > 0)) {
                    week.add(currentDay++);
                } else {
                    week.add(null);
                }
            }
            calendar.add(week);
        }

        model.addAttribute("calendar", calendar);
        return "/project/volunteer";
    }
}
	
