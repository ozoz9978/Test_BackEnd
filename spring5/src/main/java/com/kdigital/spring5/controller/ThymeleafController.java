package com.kdigital.spring5.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdigital.spring5.dto.Friend;

@Controller
public class ThymeleafController {
	@GetMapping("/display/text")
	public String text(Model model) {
		// 문자출력을 위한 데이터
		String korean = "대한민국~~★♨";
		String english = "Hello, Everyone!!!";
		String tag = "<marquee>돌이 굴러가유~</marquee>";
		
		// 숫자 출력을 위한 데이터 준비
		int age =30;
		double pi = Math.PI;
		
		// URL 출력을 위한 데이터 준비
		String url = "https://naver.com";
		
		// 빈데이터와 null 데이터 준비
		String nullData = null;
		String emptyData = "";
		
		model.addAttribute("korean",korean);
		model.addAttribute("english",english);
		model.addAttribute("tag",tag);
		
		model.addAttribute("age",age);
		model.addAttribute("pi",pi);
		model.addAttribute("url",url);
		
		model.addAttribute("nullData",nullData);
		model.addAttribute("emptyData",emptyData);
		
		
		return "thyme_text";
	}
	
	@GetMapping("/display/receive")
	public String receive (
		@RequestParam(name="name", defaultValue="모모") String name
		,@RequestParam(name="age", defaultValue="23") int age
		){
		System.out.println(name+","+age);
		return "index";
	}
}