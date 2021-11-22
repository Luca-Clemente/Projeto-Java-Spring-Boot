package com.example.projetospringboot.application.model;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class ObraService {
	
	@Autowired
	ObraDAO cdao;
	
	public void inserirObra(Obra o) {
		cdao.inserirObra(o);
	}
	public Map<String,Object> getObra (int id) {
		return cdao.getObra(id);
	}
	public List getObras(){
		return cdao.getObras();
	}
	public void deleteObra(int id) {
		cdao.deleteObra(id);
	}

}
