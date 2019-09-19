package com.everis.bootcamp.tallerjunit;

public class Articulo {
	
	private Long id;
	private String descripcion;
	private Double precio;
	
	public Articulo() {
		super();		
	}
	
	public Articulo(String descripcion, Double precio) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Articulo(Long id, String descripcion, Double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
