package com.example.projetospringboot.application.model;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class MateriaisService {
	
	@Autowired
	MateriaisDAO cdao;
	
	public void inserirMaterial(Materiais m) {
		cdao.inserirMaterial(m);
	}
	public Map<String,Object> getMaterial (int id) {
		return cdao.getMaterial(id);
	}
	public List getMateriais(){
		return cdao.getMateriais();
	}
	
}
