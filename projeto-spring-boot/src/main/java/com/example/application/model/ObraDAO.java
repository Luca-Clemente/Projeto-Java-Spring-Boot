package com.example.projetospringboot.application.model;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ObraDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirObra(Obra obra) {
		String sql = "INSERT INTO obra(nome,autor,ano)" +
					" VALUES (?,?,?) ";
		Object[] obj = new Object[3];
		obj[0] = obra.getNome();
		obj[1] = obra.getAutor();
		obj[2] = obra.getAno();
		jdbc.update(sql,obj);
	}
	public Map<String, Object> getObra(int id){
		String sql = "SELECT * FROM obra WHERE obra.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);
	}
	public List getObras(){
		String sql = "SELECT * FROM obra";
		List obras = (List) jdbc.queryForList(sql);
		return obras;
	}
	public void deleteObra(int id) {
		String sql = "DELETE FROM obra WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql,obj);
	}
}
