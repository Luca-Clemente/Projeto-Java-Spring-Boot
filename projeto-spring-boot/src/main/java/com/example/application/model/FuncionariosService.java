package com.example.projetospringboot.application.model;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class FuncionariosService {
	
	@Autowired
	FuncionariosDAO cdao;
	
	public void inserirFuncionario(Funcionarios f) {
		cdao.inserirFuncionario(f);
	}
	public Map<String,Object> getFuncionario (int id) {
		return cdao.getFuncionario(id);
	}
	public List getFuncionarios(){
		return cdao.getFuncionarios();
	}
	public void deleteFuncionario(int id) {
		cdao.deleteFuncionario(id);
	}
	public void atualizarFuncionario(int id, Funcionarios f){
		cdao.atualizarFuncionario(id, f);
	}
	
}
