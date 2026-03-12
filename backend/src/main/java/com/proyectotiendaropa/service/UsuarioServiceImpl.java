package com.proyectotiendaropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectotiendaropa.model.Usuario;
import com.proyectotiendaropa.resources.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) repository.findAll();
	}

	@Override
	public boolean addUsuario(Usuario usuario) {
		try {
			repository.save(usuario);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
