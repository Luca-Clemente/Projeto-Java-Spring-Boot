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

import com.example.projetospringboot.application.model.Funcionarios;
import com.example.projetospringboot.application.model.FuncionariosService;
import com.example.projetospringboot.application.model.Obra;
import com.example.projetospringboot.application.model.ObraService;

@Controller
public class FuncionariosController {
	
	@Autowired
	private ApplicationContext context;

	@GetMapping("/funcionarios")
	public String form(Model model) {
		model.addAttribute("funcionarios",new Funcionarios());
		return "formfuncionarios";
	}
	@PostMapping("/funcionarios")
	public String postFuncionario(@ModelAttribute Funcionarios fnc, Model model) {
		FuncionariosService fnr = context.getBean(FuncionariosService.class);
		fnr.inserirFuncionario(fnc);
		return "sucessofuncionarios";
	}
	@GetMapping("/funcionarios/{id}")
		public String getFuncionarios(@PathVariable("id")
	 int id, Model model) {
		FuncionariosService fnr = context.getBean(FuncionariosService.class);
		Map<String,Object> mapa = fnr.getFuncionario(id);
		model.addAttribute("nome",mapa.get("nome"));
		model.addAttribute("cargo",mapa.get("cargo"));
		model.addAttribute("id",id);
		return "funcionario";
	}
	@GetMapping("/listafuncionarios")
	public String listar(Model model) {
		FuncionariosService fnr = context.getBean(FuncionariosService.class);
		List funcionarios = fnr.getFuncionarios();
		model.addAttribute("funcionarios", funcionarios);
		return "listafuncionarios";
	}
	@PostMapping("/apagar/funcionarios/{id}")
	public String apagarFuncionario(@PathVariable("id") int id) {
		FuncionariosService cdao = context.getBean(FuncionariosService.class);
		cdao.deleteFuncionario(id);
		return "redirect:/listafuncionarios";
	}
	@GetMapping("/upd/compradores/{id")
	public String formFuncionarios(@PathVariable("id") int id, Model model) {
		FuncionariosService cdao = context.getBean(FuncionariosService.class);
		Map<String,Object> regs = cdao.getFuncionario(id);
		Funcionarios fnc = new Funcionarios(id,regs.get("nome").toString(),regs.get("cargo").toString());
		model.addAttribute("funcionarios",fnc);
		model.addAttribute("id",id);
		return "formupdfuncionario";
	}
	
	@PostMapping("/upd/compradores/{id}")
	public String atualizarFuncionarios(@PathVariable("id") int id, 
			                       Model model,
			                       @ModelAttribute Funcionarios fnc) {
		FuncionariosService cdao = context.getBean(FuncionariosService.class);
		cdao.atualizarFuncionario(id, fnc);
		return "redirect:/listafuncionarios";
	}
}
