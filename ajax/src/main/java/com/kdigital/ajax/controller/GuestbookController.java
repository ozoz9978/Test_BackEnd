package com.kdigital.ajax.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kdigital.ajax.dto.GuestbookDTO;
import com.kdigital.ajax.service.GuestbookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class GuestbookController {
	
	final GuestbookService service;
	
	@GetMapping("/guestbookpage")
	public String guestbook(Model model) {
		List<GuestbookDTO> list = null;
		
		// DB로부터 데이터를 불러오는 작업
		list = service.selectAll();
		
		model.addAttribute("list", list);
		
		return "guest/guestbook";
	}
	@GetMapping("/retrieveAll")
	public List<GuestbookDTO> retrieveAll(){
		
		List<GuestbookDTO> list = service.retrieveAll();
		
		return list;
	}
	@PostMapping("/deleteGuestbook")
	public String deleteGuestbook (
			@RequestParam(name="seq")Long seq
			,@RequestParam(name="pwd")String pwd) {

		service.deleteGuestbook(seq, pwd);
		return "OK";
	}

}
