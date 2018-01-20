package com.ertheia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ertheia.model.Profissao1;
import com.ertheia.model.Usuario;

//O metodo JpaRepository possui os metodos do banco para realização qualquer ação!
//O segundo parametro é o tipo de dado do ID da classe usuario, no caso, em usuário é LONG
//Esse é o Spring Data
//Primeiro vem aqui, cria uma interface, extendi no respositorio  e ja 
//dar um autowire (no usuariocontroller) pra poder usar
public interface Usuarios extends JpaRepository<Usuario,Long> {
	
	Usuario findByNome (String nome);
	
	
	@Query("from Usuario where nome like concat(?1, '%')")
	List<Usuario> pesquisarUsuario(String nome);
	

}
