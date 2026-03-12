package com.proyectotiendaropa.service;

import java.util.List;

import com.proyectotiendaropa.model.Ropa;

public interface RopaService {
	
	public List<Ropa> findAll();
	
	public boolean addRopa(Ropa ropa);
	
	//public List<Ropa> findByTitulo(String titulo);
}
