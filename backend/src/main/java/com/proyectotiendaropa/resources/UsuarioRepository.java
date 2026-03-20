package com.proyectotiendaropa.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.proyectotiendaropa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByCorreo (String correo);
}

