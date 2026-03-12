package com.proyectotiendaropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectotiendaropa.model.Imagen;
import com.proyectotiendaropa.resources.ImagenRepository;

@Service
public class ImagenServiceImpl implements ImagenService{
	
	@Autowired
	private ImagenRepository repository;

	@Override
	public List<Imagen> findAll() {
		return (List<Imagen>) repository.findAll();
	}

	@Override
	public boolean addImagen(Imagen imagen) {
		try {
			repository.save(imagen);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
