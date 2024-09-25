package com.kdigital.ajax.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdigital.ajax.dto.CustomerDTO;

@Controller
public class SecondController {
	@GetMapping("/secondpage")
	public String secondpage() {
		return "second";
	}
	
	@GetMapping("/receive")
	@ResponseBody
	public List<CustomerDTO> receive() {
		List<CustomerDTO> list =Arrays.asList(
				new CustomerDTO("홍길동", "hong@naver.com","010-6766-0817")
				,new CustomerDTO("임꺽정", "guuck@naver.com","010-3423-0817")
				,new CustomerDTO("초파리", "cho@naver.com","010-6766-6789")
				,new CustomerDTO("손오공", "monk@naver.com","010-3423-0097")
				,new CustomerDTO("사오정", "deaf@naver.com","010-6766-9989")	
				);
		return list;
				
	}
	
	
	
}
