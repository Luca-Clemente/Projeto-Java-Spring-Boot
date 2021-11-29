package com.example.projetospringboot.application.model;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class MateriaisDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirMaterial(Materiais materiais) {
		String sql = "INSERT INTO materiais(nome,quantidade)" +
					" VALUES (?,?) ";
		Object[] obj = new Object[2];
		obj[0] = materiais.getNome();
		obj[1] = materiais.getQuantidade();
		jdbc.update(sql,obj);
	}
	public Map<String, Object> getMaterial(int id){
		String sql = "SELECT * FROM materiais WHERE materiais.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);
	}
	public List getMateriais(){
		String sql = "SELECT * FROM materiais";
		List materiais = (List) jdbc.queryForList(sql);
		return materiais;
	}
}
