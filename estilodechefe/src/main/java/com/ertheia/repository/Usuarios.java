package com.ertheia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ertheia.model.Usuario;

//O metodo JpaRepository possui os metodos do banco para realização qualquer ação!
//O segundo parametro é o tipo de dado do ID da classe usuario, no caso, em usuário é LONG
//Esse é o Spring Data
//Primeiro vem aqui, cria uma interface, extendi no respositorio  e ja 
//dar um autowire (no usuariocontroller) pra poder usar
public interface Usuarios extends JpaRepository<Usuario,Long> {

}
