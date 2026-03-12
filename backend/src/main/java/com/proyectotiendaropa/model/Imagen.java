package com.proyectotiendaropa.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "imagen")
public class Imagen implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagen")
	private Integer idImagen;
	
	@Lob
	@Column(name = "imagen")
	private byte[] imagen;
	
	public Imagen() {
		
	}

	public Imagen(Integer idImagen, byte[] imagen) {
		super();
		this.idImagen = idImagen;
		this.imagen = imagen;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}