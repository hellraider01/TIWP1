package com.frontend.models;

public class Product {
	
	private String nombre;
	
	private double precio;
	
	private boolean activo;

	public Product(String nombre, double precio, boolean activo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
}
