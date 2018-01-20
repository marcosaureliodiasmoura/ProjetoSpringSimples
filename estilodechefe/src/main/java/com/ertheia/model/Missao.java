package com.ertheia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Missao{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nomeMissao;
	private String descricaoMissao;
	private int nivelMissao;
	private String requisitosMissao;
	private double recompensaMissao;
	private boolean missaoVisivel;
	
//	 Usuario responsavel; 
	
//	public Usuario usuarios[];
	
	

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeMissao() {
		return nomeMissao;
	}
	public void setNomeMissao(String nomeMissao) {
		this.nomeMissao = nomeMissao;
	}
	public String getDescricaoMissao() {
		return descricaoMissao;
	}
	public void setDescricaoMissao(String descricaoMissao) {
		this.descricaoMissao = descricaoMissao;
	}
	public int getNivelMissao() {
		return nivelMissao;
	}
	public void setNivelMissao(int nivelMissao) {
		this.nivelMissao = nivelMissao;
	}
	public String getRequisitosMissao() {
		return requisitosMissao;
	}
	public void setRequisitosMissao(String requisitosMissao) {
		this.requisitosMissao = requisitosMissao;
	}
	public double getRecompensaMissao() {
		return recompensaMissao;
	}
	public void setRecompensaMissao(double recompensaMissao) {
		this.recompensaMissao = recompensaMissao;
	}
	public boolean isMissaoVisivel() {
		return missaoVisivel;
	}
	public void setMissaoVisivel(boolean missaoVisivel) {
		this.missaoVisivel = missaoVisivel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Missao other = (Missao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

	
	
	
	
}