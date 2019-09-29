package com.frontend.dao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.frontend.models.Categoria;
import com.frontend.models.Product;
import com.frontend.models.Usuario;

public class CategoriaStore {

	private static List<Categoria> categorias = new ArrayList<Categoria>();
	
	private static int ids = 0;

	public static void init() {
		categorias.add(new Categoria(ids,"Servicios"));
		categorias.add(new Categoria(ids++,"Informstica"));
		categorias.add(new Categoria(ids++,"Libros"));
	}

	public static List<Categoria> getCategorias() {
		return categorias;
	}

	public static void setCategorias(List<Categoria> categoria) {
		CategoriaStore.categorias = categoria;
	}

	public static Categoria findById(int id) {
		for (Categoria p : CategoriaStore.categorias) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public static Categoria findByName(String nombre) {
		for (Categoria p : CategoriaStore.categorias) {
			if (p.getNombre().contains(nombre)) {
				return p;
			}
		}
		return null;
	}

	public static void createCategoria(String nombre) {
		Categoria pro = new Categoria();
		pro.setId(CategoriaStore.categorias.size() + 1);
		pro.setNombre(nombre);
		CategoriaStore.categorias.add(pro);
	}

	public static void actualizarCategoria(int id, String nombre) {
		int idf = 0;
		Categoria pd = null;
		for (int i = 0; i <= CategoriaStore.categorias.size() - 1; i++) {
			Categoria p = CategoriaStore.categorias.get(i);
			if (p.getId() == id) {
				idf = i;
				pd = p;
			}
		}
		CategoriaStore.categorias.remove(idf);
		pd = CategoriaStore.findById(id);
		pd.setNombre((String) nombre);
		CategoriaStore.categorias.add(idf, pd);
	}

	public static void eliminarCategoria(int id) {
		int idf = 0;
		for (int i = 0; i <= CategoriaStore.categorias.size() - 1; i++) {
			Categoria p = CategoriaStore.categorias.get(i);
			if (p.getId() == id) {
				idf = i;
			}
		}
		CategoriaStore.categorias.remove(idf);
	}

}
