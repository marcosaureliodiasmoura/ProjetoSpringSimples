package com.ertheia.model;

import java.util.Objects;

public enum StatusProfissional {
	
	
	MODELO(1,"Modelo"),
//	ADMNISTRAÇÃO
//	TURISMO
//	GASTRONOMIA
//	MARKETING
//	CORRETORDEIMOVEIS
//	DANÇARINO
//	DESIGNDEMODA
//	DESIGN
	FOTOGRAFO(2,"Fotografo");
//	MÚSICOS
//	ATOR
//	NUTRICIONISTA
//	PROFESSORDEEDUCACAOFISICA
//	PROGRAMADORDESISTMAS
//	HACKER
//	ADVOGADO
//	CINEMATOGRAFICO
//	REDATOR
//	JORNALISTA
//	MEDICO
//	ENGENHEIROCIVIL
//	ENGENHEIRO
//	PROFESSOREDUCACAOFISICA
//	YOGUEIROS
//	CANTORES
//	FISIOTERAPIA
//	PSICOLOGO
//	DENTISTA
//	TRADUTOR
	//Pra salvar em cada Nome cadastrado
	
	public int profissao;
	public String nomexx;
	
	private StatusProfissional(int profissao, String nomexx)
	{
		this.profissao = profissao;
		this.nomexx = nomexx;
	}
	
	public String getNomexx(){
		return nomexx;
	}
	
	public int getProfissao()
	{
		return profissao;
	}
		
		
		 public static StatusProfissional parse(int id) {
			 StatusProfissional statusprofissional = null; 
		        for (StatusProfissional item : StatusProfissional.values()) {
		            if (Objects.equals(item.getProfissao(), id)) {
		            	statusprofissional = item;
		                break;
		            }
		        }
		        return statusprofissional;
		 }
		
		 @Override
		 public String toString()
		 {
			 return this.nomexx;
		 }
		 
}
