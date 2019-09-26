package com.frontend.models;

public class Product {
	
	private int id;
	
	private String nombre;
	
	private double precio;
	
	private boolean activo;
	
	

	public Product() {
		super();
	}

	public Product(int id, String nombre, double precio, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.activo = activo;
	}

	public Product(String nombre, double precio, boolean activo) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
