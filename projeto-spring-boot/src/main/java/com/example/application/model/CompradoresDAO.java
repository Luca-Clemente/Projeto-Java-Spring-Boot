package com.example.projetospringboot.application.model;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class CompradoresDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirComprador(Compradores compradores) {
		String sql = "INSERT INTO compradores(nome,email)" +
					" VALUES (?,?) ";
		Object[] obj = new Object[2];
		obj[0] = compradores.getNome();
		obj[1] = compradores.getEmail();
		jdbc.update(sql,obj);
	}
	public Map<String, Object> getComprador(int id){
		String sql = "SELECT * FROM compradores WHERE compradores.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);
	}
	public List getCompradores(){
		String sql = "SELECT * FROM compradores";
		List compradores = (List) jdbc.queryForList(sql);
		return compradores;
	}
}
