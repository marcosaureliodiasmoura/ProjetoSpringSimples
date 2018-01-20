package com.ertheia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;


@Entity
public class Profissao1 implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	
	private String nome;
	private String descricao;
	private int nivel;
	
//	@ManyToMany(targetEntity=Usuario.class)
//	private	Set usuarioSet;	
	
	
	

	public Profissao1() {
		super();
	}

	public Profissao1(Long codigo, String nome, String descricao, int nivel
			,Set usuarioSet
			) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.nivel = nivel;
//		this.usuarioSet = usuarioSet;

	}
	
	

	
	
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

//	public Set getUsuarioSet() {
//		return usuarioSet;
//	}
//
//	public void setUsuarioSet(Set usuarioSet) {
//		this.usuarioSet = usuarioSet;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissao1 other = (Profissao1) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
