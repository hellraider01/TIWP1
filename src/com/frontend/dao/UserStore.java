package com.frontend.dao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.frontend.models.Categoria;
import com.frontend.models.Product;
import com.frontend.models.Usuario;

public class UserStore {

	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public static void init() {
		usuarios.add(new Usuario(0, "admin", "admin", "avenida universidad", "admin@admin.com", "1234", 0));
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setProductos(List<Usuario> usuarios) {
		UserStore.usuarios = usuarios;
	}

	public static Usuario findById(int id) {
		for (Usuario p : UserStore.usuarios) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public static Usuario login(String email, String password) {
		for (Usuario u : UserStore.usuarios) {
			if (u.getEmail().compareTo(email) == 0 && u.getPasswd().compareTo(password) == 0) {
				return u;
			}
		}
		return null;
	}

	public static void createUsuario(String nombre, String passwd, String apellidos, String direccion, String email) {
		Usuario pro = new Usuario();
		pro.setId(UserStore.usuarios.size() + 1);
		pro.setNombre(nombre);
		pro.setPasswd(passwd);
		pro.setApellidos(apellidos);
		pro.setDireccion(direccion);
		pro.setEmail(email);
		UserStore.usuarios.add(pro);
	}

	public static void actualizarUsuario(int id, String nombre, String passwd, String apellidos, String direccion,
			String email) {
		int idf = 0;
		Usuario pd = null;
		for (int i = 0; i <= UserStore.usuarios.size() - 1; i++) {
			Usuario p = UserStore.usuarios.get(i);
			if (p.getId() == id) {
				idf = i;
				pd = p;
			}
		}
		UserStore.usuarios.remove(idf);
		pd = UserStore.findById(id);
		pd.setNombre(nombre);
		pd.setPasswd(passwd);
		pd.setApellidos(apellidos);
		pd.setDireccion(direccion);
		pd.setEmail(email);
		UserStore.usuarios.add(idf, pd);
	}

	public static void eliminarUsuario(int id) {
		int idf = 0;
		for (int i = 0; i <= UserStore.usuarios.size() - 1; i++) {
			Usuario p = UserStore.usuarios.get(i);
			if (p.getId() == id) {
				idf = i;
			}
		}
		UserStore.usuarios.remove(idf);
	}

}
