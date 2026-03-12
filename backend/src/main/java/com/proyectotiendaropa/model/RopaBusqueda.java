package com.proyectotiendaropa.model;

import java.util.List;

public class RopaBusqueda {

	private int idRopa;
	private String intro;
	private String descripcion;
	private List<String> imagenes;
	private double precio;
	private Marca marca;
	private String genero;
	private String talla;
	private String color;
	

	public RopaBusqueda() {
		super();
	}

	public RopaBusqueda(int idRopa, String intro, String descripcion, List<String> imagenes, double precio) {
		super();
		this.idRopa = idRopa;
		this.intro = intro;
		this.descripcion = descripcion;
		this.imagenes = imagenes;
		this.precio = precio;
	}
	
	public RopaBusqueda(int idRopa, String intro, String descripcion, String genero, String talla, String color,
			double precio, Marca marca, List<String> imagenes) {
		super();
		this.idRopa = idRopa;
		this.intro = intro;
		this.descripcion = descripcion;
		this.genero = genero;
		this.talla = talla;
		this.color = color;
		this.precio = precio;
		this.marca = marca;
		this.imagenes = imagenes;
	}

	public int getIdRopa() {
		return idRopa;
	}

	public void setIdRopa(int idRopa) {
		this.idRopa = idRopa;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "RopaBusqueda [idRopa=" + idRopa + ", intro=" + intro + ", descripcion=" + descripcion + ", imagenes="
				+ imagenes + "]";
	}

}
