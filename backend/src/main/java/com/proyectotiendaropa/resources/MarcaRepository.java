package com.proyectotiendaropa.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.proyectotiendaropa.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}

