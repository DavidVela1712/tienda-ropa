package com.proyectotiendaropa.model;

public class Buscar{
	
	private String descripcion;
	private String genero;
	private int precio;
	
	public Buscar() {
		super();
	}

	public Buscar(String descripcion, String genero, int precio) {
		super();
		this.descripcion = descripcion;
		this.genero = genero;
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}