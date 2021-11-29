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

import com.example.projetospringboot.application.model.Materiais;
import com.example.projetospringboot.application.model.MateriaisService;

@Controller
public class MateriaisController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/materiais")
	public String form(Model model) {
		model.addAttribute("materiais",new Materiais());
		return "formmateriais";
	}
	@PostMapping("/materiais")
	public String postMaterial(@ModelAttribute Materiais mtr, Model model) {
		MateriaisService mte = context.getBean(MateriaisService.class);
		mte.inserirMaterial(mtr);
		return "sucessomateriais";
	}
	@GetMapping("/materiais/{id}")
		public String getMateriais(@PathVariable("id")
	 int id, Model model) {
		MateriaisService mte = context.getBean(MateriaisService.class);
		Map<String,Object> mapa = mte.getMaterial(id);
		model.addAttribute("nome",mapa.get("nome"));
		model.addAttribute("quantidade",mapa.get("quantidade"));
		model.addAttribute("id",id);
		return "material";
	}
	@GetMapping("/listamateriais")
	public String listar(Model model) {
		MateriaisService mte = context.getBean(MateriaisService.class);
		List materiais = mte.getMateriais();
		model.addAttribute("materiais", materiais);
		return "listamateriais";
	}
}
