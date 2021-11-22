package com.example.projetospringboot.application.model;

public class Obra {
	
	private int id;
	private String nome,autor,ano;
	
	public Obra() {
		
	}
	
	public Obra (int id, String nome, String autor, String ano) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
	}
	
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
}
