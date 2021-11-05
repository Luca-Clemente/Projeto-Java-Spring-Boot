package com.example.projetospringboot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class PrincipalController {

	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/sobre")
	public String pagSobre() {
		return "sobre";
	}
	
	@GetMapping("/cardapio")
	public String pagCardapio() {
		return "cardapio";
	}
	
}
