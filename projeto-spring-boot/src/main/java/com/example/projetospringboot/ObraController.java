package com.example.projetospringboot;
import com.example.projetospringboot.application.model.Obra;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.example.projetospringboot.application.model.ObraService;

@Controller

public class ObraController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/obra")
	public String formObra(Model model) {
		model.addAttribute("obra",new Obra());
		return "formobra";
	}
	@PostMapping("/obra")
	public String postObra(@ModelAttribute Obra obr, Model model) {
		ObraService os = context.getBean(ObraService.class);
		os.inserirObra(obr);
		return "sucesso";
	}
	@GetMapping("/obras/{id}")
		public String getObras(@PathVariable("id")
	 int id, Model model) {
		ObraService os = context.getBean(ObraService.class);
		Map<String,Object> mapa = os.getObra(id);
		model.addAttribute("nome",mapa.get("nome"));
		model.addAttribute("autor",mapa.get("autor"));
		model.addAttribute("ano",mapa.get("ano"));
		model.addAttribute("id",id);
		return "obras";
	}
	@GetMapping("/obras")
	public String listar(Model model) {
		ObraService os = context.getBean(ObraService.class);
		List obras = os.getObras();
		model.addAttribute("obras", obras);
		return "listaobras";
	}
	@PostMapping("/apagar/obra/{id}")
	public String apagarObra(@PathVariable("id") int id) {
		ObraService cdao = context.getBean(ObraService.class);
		cdao.deleteObra(id);
		return "redirect:/obras";
	}
} 
