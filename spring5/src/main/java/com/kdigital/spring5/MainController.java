package com.kdigital.spring5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/",""})
	public String index() {
		return "index"; // templates/index.html
	}
	
}
