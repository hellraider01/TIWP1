package com.frontend.servicio;

import java.util.ArrayList;
import java.util.List;

import com.frontend.models.Product;

public class ProductStore {
	
	private List<Product> productos=new ArrayList<Product>();
	String[] nombres = { "Champu", "Ordenador", "Teclado", "Playstation", "Portatil", "Bascula", "Tornillo", "Servidor"};
	
	public List<Product> init() {
		for(String nom: nombres) {
			double precio = Math.random()*25 + 1;
			productos.add(new Product(nom, precio, true));
		}
		return productos;
	}


	public List<Product> getProductos() {
		return productos;
	}


	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

}
