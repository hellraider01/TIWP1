package com.frontend.dao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.frontend.models.Product;

public class ProductStore {

	private static List<Product> productos = new ArrayList<Product>();
	private static String[] nombres = { "Champu", "Ordenador", "Teclado", "Playstation", "Portatil", "Bascula",
			"Tornillo", "Servidor" };
	private static int ids = 0;

	public static void init() {
		for (String nom : nombres) {
			double precio = Math.random() * 25 + 1;
			productos.add(new Product(ids, nom, precio, true));
			ids = ids + 1;
		}
	}

	public static List<Product> getProductos() {
		return productos;
	}

	public static void setProductos(List<Product> productos) {
		ProductStore.productos = productos;
	}

	public static Product findById(int id) {
		for (Product p : ProductStore.productos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public static Product findByName(String nombre) {
		for (Product p : ProductStore.productos) {
			if (p.getNombre().contains(nombre)) {
				return p;
			}
		}
		return null;
	}

	public static void createProduct(String nombre, double precio) {
		Product pro = new Product();
		pro.setId(ProductStore.productos.size() + 1);
		pro.setNombre((String) nombre);
		pro.setPrecio((double) precio);
		ProductStore.productos.add(pro);
	}

	public static void actualizarProduct(int id, String nombre, double precio) {
		int idf = 0;
		Product pd = null;
		for (int i = 0; i <= ProductStore.productos.size() - 1; i++) {
			Product p = ProductStore.productos.get(i);
			if (p.getId() == id) {
				idf = i;
				pd = p;

			}
		}
		ProductStore.productos.remove(idf);
		pd = ProductStore.findById(id);
		pd.setNombre((String) nombre);
		pd.setPrecio((double) precio);
		ProductStore.productos.add(idf, pd);
	}

	public static void eliminarProduct(int id) {
		int idf = 0;
		for (int i = 0; i <= ProductStore.productos.size() - 1; i++) {
			Product p = ProductStore.productos.get(i);
			if (p.getId() == id) {
				idf = i;
			}
		}
		ProductStore.productos.remove(idf);
	}

}
