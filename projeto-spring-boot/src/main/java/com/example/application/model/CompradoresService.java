package com.example.projetospringboot.application.model;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class CompradoresService {
	
	@Autowired
	CompradoresDAO cdao;
	
	public void inserirComprador(Compradores c) {
		cdao.inserirComprador(c);
	}
	public Map<String,Object> getObra (int id) {
		return cdao.getComprador(id);
	}
	public List getCompradores(){
		return cdao.getCompradores();
	}
	
}
