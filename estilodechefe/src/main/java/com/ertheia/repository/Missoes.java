package com.ertheia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ertheia.model.Missao;



public interface Missoes extends JpaRepository<Missao,Long> {

}