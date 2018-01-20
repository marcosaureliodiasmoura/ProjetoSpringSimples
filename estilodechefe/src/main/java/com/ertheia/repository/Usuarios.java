package com.ertheia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ertheia.model.Usuario;


public interface Usuarios extends JpaRepository<Usuario,Long> {

}
