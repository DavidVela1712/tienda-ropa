package com.proyectotiendaropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyectotiendaropa.model.Usuario;
import com.proyectotiendaropa.resources.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Usuario login(Usuario usuario) {

		System.out.println("Usuario recibido en login: "+ usuario);

		if (usuario.getCorreo() == null || usuario.getPassword() == null){
			throw  new RuntimeException("Correo o contraseña vacío");
		}
		Usuario userDB = repository.findUsuarioByCorreo(usuario.getCorreo());
		System.out.println("Usuario encontrado: "+ userDB);

		if (userDB == null) {
			throw new RuntimeException("Usuario no encontrado");
		}

		if (!passwordEncoder.matches(usuario.getPassword(), userDB.getPassword())){
			throw new RuntimeException("Contraseña incorrecta");
		}
        return userDB;
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	//Eliminar
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

	@Override
	public Usuario crearUsuario(Usuario usuario) {

		System.out.println(usuario.toString());

		if (usuario.getPassword() == null){
			throw new RuntimeException("Password no puede ser null");
		}
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return repository.save(usuario);
	}
}
