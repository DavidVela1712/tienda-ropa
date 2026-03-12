package com.proyectotiendaropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectotiendaropa.model.Ropa;
import com.proyectotiendaropa.resources.RopaRepository;

@Service
public class RopaServiceImpl implements RopaService{
	
	@Autowired
	private RopaRepository repository;

	@Override
	public List<Ropa> findAll() {
		return (List<Ropa>) repository.findAll();
	}

	@Override
	public boolean addRopa(Ropa ropa) {
		try {
			repository.save(ropa);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
}
