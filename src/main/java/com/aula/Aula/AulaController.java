package com.aula.Aula;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AulaController {
	
	@GetMapping("/")
	public String principal() {
		return "index";
	}
}
