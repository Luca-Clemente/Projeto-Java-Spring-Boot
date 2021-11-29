package com.example.projetospringboot.application.model;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class FuncionariosDAO {

	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirFuncionario(Funcionarios funcionarios) {
		String sql = "INSERT INTO funcionarios(nome,cargo)" +
					" VALUES (?,?) ";
		Object[] obj = new Object[2];
		obj[0] = funcionarios.getNome();
		obj[1] = funcionarios.getCargo();
		jdbc.update(sql,obj);
	}
	public Map<String, Object> getFuncionario(int id){
		String sql = "SELECT * FROM funcionarios WHERE funcionarios.id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql,obj);
	}
	public List getFuncionarios(){
		String sql = "SELECT * FROM funcionarios";
		List funcionarios = (List) jdbc.queryForList(sql);
		return funcionarios;
	}
	public void deleteFuncionario(int id) {
		String sql = "DELETE FROM funcionarios WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql,obj);
	}
	 public void atualizarFuncionario(int id, Funcionarios funcionarios) {
			String sql = "UPDATE funcionarios "
					+    "SET nome = ?, cargo = ? "
					+    "WHERE id = ?" ;
			Object[] obj = new Object[3];
			obj[0] = funcionarios.getNome();
			obj[1] = funcionarios.getCargo();;
			obj[2] = id;
			jdbc.update(sql, obj);
		}
}
