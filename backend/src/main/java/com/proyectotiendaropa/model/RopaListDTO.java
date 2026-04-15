package com.proyectotiendaropa.model;

public class RopaListDTO {

	private int idRopa;
	private String descripcion;
	private double precio;

	public RopaListDTO(int idRopa, String descripcion, double precio) {
		this.idRopa = idRopa;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public RopaListDTO(Ropa ropa){
		this.idRopa = ropa.getIdRopa();
		this.descripcion = ropa.getDescripcion();
		this.precio = ropa.getPrecio();
	}

	public int getIdRopa() {
		return idRopa;
	}

	public void setIdRopa(int idRopa) {
		this.idRopa = idRopa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "RopaListDTO{" +
				"idRopa=" + idRopa +
				", descripcion='" + descripcion + '\'' +
				", precio=" + precio +
				'}';
	}
}
