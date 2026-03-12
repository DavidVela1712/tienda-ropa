package com.proyectotiendaropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectotiendaropa.model.Marca;
import com.proyectotiendaropa.resources.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService{
	
	@Autowired
	private MarcaRepository repository;

	@Override
	public List<Marca> findAll() {
		return (List<Marca>) repository.findAll();
	}

	@Override
	public boolean addMarca(Marca marca) {
		try {
			repository.save(marca);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
