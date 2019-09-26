package com.frontend.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.frontend.models.Product;

public class ProductStore {
	
	private List<Product> productos=new ArrayList<Product>();
	String[] nombres = { "Champu", "Ordenador", "Teclado", "Playstation", "Portatil", "Bascula", "Tornillo", "Servidor"};
	int ids=0;
	
	public List<Product> init() {
		for(String nom: nombres) {
			double precio = Math.random()*25 + 1;
			productos.add(new Product(ids, nom, precio, true));
			ids=ids+1;
		}
		return productos;
	}


	public List<Product> getProductos() {
		return productos;
	}


	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}
	
	public Product findById(int id) {
		for(Product p:this.productos) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}
	
	public Product findByName(String nombre) {
		for(Product p:this.productos) {
			if(p.getNombre().contains(nombre)) {
				return p;
			}
		}
		return null;
	}
	
	public void createProduct(HttpServletRequest request) {
		Product pro = new Product();
		int c=0;
		pro.setId(this.productos.size()+1);
		Object nombre = request.getParameter("nombre");
		Object precio = request.getParameter("precio");
		if (request.getParameter("nombre")!=null) {
			pro.setNombre((String)nombre);
			c++;
		}
		if (request.getParameter("precio")!=null) {
			pro.setPrecio((double)precio);
			c++;
		}
		if(c==2) {
			this.productos.add(pro);
		}	
	}

}
