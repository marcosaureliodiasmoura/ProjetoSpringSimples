package com.ertheia.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ertheia.model.Profissao1;



public interface Profissoes1 extends JpaRepository<Profissao1,Long> {
	
	
	Profissao1 findByNome(String nome);
	
	
	@Query("from Profissao1 where nome like concat(?1, '%')")
	List<Profissao1> pesquisarProfissao(String nome);
	 

}