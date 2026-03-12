package com.proyectotiendaropa.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ropa")
public class Ropa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ropa")
	private int idRopa;
	
	@Column(name = "intro")
	private String intro;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "talla")
	private String talla;
	
	@Column(name = "stock")
	private Integer stock;	
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "precio")
	private double precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca")
	private Marca marca;
	
	@ManyToMany
	@JoinTable(name = "ropaimagen"
		, joinColumns = @JoinColumn(name = "id_ropa_imagen")
		, inverseJoinColumns = @JoinColumn(name = "id_imagen_ropa"))
	private List<Imagen> imagenes;
	

	public Ropa() {
		super();
	}

	public Ropa(String intro, String descripcion, String genero, String talla, Integer stock, String color,
			double precio, Marca marca, List<Imagen> imagenes) {
		super();
		this.intro = intro;
		this.descripcion = descripcion;
		this.genero = genero;
		this.talla = talla;
		this.stock = stock;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
