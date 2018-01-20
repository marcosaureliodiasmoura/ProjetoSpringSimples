package com.ertheia.model;

public enum StatusPais {
	
	
	BRAZIL("Brazil"),
	FRANCE("France"),
	ITALY("Italy"),
	AFRICA("Africa");
	
	//Pra salvar em cada Nome cadastrado
	private String nome;
	
	StatusPais(String nome){
		this.nome=nome;
		
	}
	
	public String getNome()
	{
		return nome;
	}

}
