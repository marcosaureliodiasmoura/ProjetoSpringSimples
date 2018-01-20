package com.ertheia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Usuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
//	public Missao missoes[];
	
//	Missao quests;
	
	private int nivel = 1;
	
	private double xp = 100;
	
	
	@ManyToOne
	private Profissao1 profissao;
	
	@NotEmpty(message = "Informe o Nome do Usuário")
	@Size(max = 20, message = "Aviso, o Nome não pode ultrapassar 20 Caracteres")
	private String profiss;
	
	public String getProfiss() {
		return profiss;
	}

	public void setProfiss(String profiss) {
		this.profiss = profiss;
	}
	
	
	@NotEmpty(message = "Informe o Nome do Usuário")
	@Size(max = 20, message = "Aviso, o Nome não pode ultrapassar 20 Caracteres")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo Sobrenome")
	@Size(max = 20, message = "Aviso, o Sobrenome não pode ultrapassar 20 Caracteres")
	private String sobrenome;
	
	@NotEmpty(message = "Preencha o campo E-mail")
	@Size(max = 40, message = "Aviso, o Email não pode ultrapassar 40 Caracteres")
	private String email;
	
	@NotNull(message = "Data não pode ser nulo")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotEmpty(message = "Informe o seu Telefone")
	@Size(max = 12, message = "Aviso, o telefone não pode ultrapassar 12 Caracteres")
	private String telefone;
	
	@NotEmpty(message = "Preencha o campo Estado")
	@Size(max = 20, message = "Aviso, o Estado não pode ultrapassar 20 Caracteres")
	private String estado;
	
	
	//Salva o valor no banco de dados no tipo String
	@Enumerated(EnumType.STRING)
	private StatusPais pais;
	
	@Enumerated(EnumType.STRING)
	private StatusPerfil perfil;
	
	
	//ghc hash code
	
	//ggas
	public Long getCodigo() {
		return codigo;
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
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
	
	public int getNivel()
	{
		return nivel;
	}
	
	public void setNivel(int nivel)
	{
		this.nivel = nivel;
	}
	
	public double getXp()
	{
		return xp;
	}
	
	public void setXp(double xp)
	{
		this.xp = xp;
	}
	

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public StatusPais getPais() {
		return pais;
	}

	public void setPais(StatusPais pais) {
		this.pais = pais;
	}

	public StatusPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(StatusPerfil perfil) {
		this.perfil = perfil;
	}

	public Profissao1 getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao1 profissao) {
		this.profissao = profissao;
	}
	
	
	


	
}
