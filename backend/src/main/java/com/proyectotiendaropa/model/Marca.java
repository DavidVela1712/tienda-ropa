package com.proyectotiendaropa.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca")
	private int idMarca;
	
	@Column(name = "nombre")
	private String nombre;
	
	public Marca() {
		
	}

	public Marca(Integer idMarca, String nombre) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}