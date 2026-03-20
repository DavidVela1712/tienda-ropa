package com.proyectotiendaropa.service;

import java.util.List;

import com.proyectotiendaropa.model.Usuario;

public interface UsuarioService {

	public boolean login(Usuario usuario);
	
	public List<Usuario> findAll();
	
	public boolean addUsuario(Usuario usuario);

	public Usuario crearUsuario(Usuario usuario);
}