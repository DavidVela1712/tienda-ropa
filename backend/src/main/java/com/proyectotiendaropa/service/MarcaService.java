package com.proyectotiendaropa.service;

import java.util.List;

import com.proyectotiendaropa.model.Marca;

public interface MarcaService {
	
	public List<Marca> findAll();
	
	public boolean addMarca(Marca marca);
}