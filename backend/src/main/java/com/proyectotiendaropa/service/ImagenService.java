package com.proyectotiendaropa.service;

import java.util.List;

import com.proyectotiendaropa.model.Imagen;

public interface ImagenService {
	
	public List<Imagen> findAll();
	
	public boolean addImagen(Imagen imagen);
}