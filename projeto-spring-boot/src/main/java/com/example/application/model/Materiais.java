package com.example.projetospringboot.application.model;

public class Materiais {
	
	private int id, quantidade;
	private String nome;
	
	public Materiais() {
		
	}
	
	public Materiais (int id, int quantidade, String nome) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
