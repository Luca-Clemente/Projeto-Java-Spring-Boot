package com.example.projetospringboot;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projetospringboot.application.model.Compradores;
import com.example.projetospringboot.application.model.CompradoresService;
import com.example.projetospringboot.application.model.ObraService;

@Controller
public class CompradoresController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/compradores")
	public String form(Model model) {
		model.addAttribute("compradores",new Compradores());
		return "formcompradores";
	}
	@PostMapping("/compradores")
	public String postComprador(@ModelAttribute Compradores cpr, Model model) {
		CompradoresService cmp = context.getBean(CompradoresService.class);
		cmp.inserirComprador(cpr);
		return "sucessocompradores";
	}
	@GetMapping("/compradores/{id}")
		public String getCompradores(@PathVariable("id")
	 int id, Model model) {
		CompradoresService cmp = context.getBean(CompradoresService.class);
		Map<String,Object> mapa = cmp.getObra(id);
		model.addAttribute("nome",mapa.get("nome"));
		model.addAttribute("email",mapa.get("email"));
		model.addAttribute("id",id);
		return "comprador";
	}
	@GetMapping("/listacompradores")
	public String listar(Model model) {
		CompradoresService cmp = context.getBean(CompradoresService.class);
		List compradores = cmp.getCompradores();
		model.addAttribute("compradores", compradores);
		return "listacompradores";
	}
}
