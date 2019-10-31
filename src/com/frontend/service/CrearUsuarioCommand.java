package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.UserStore;

public class CrearUsuarioCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("nombre");
		String dirrecion = request.getParameter("nombre");
		String email = request.getParameter("nombre");
		String passwd = request.getParameter("password");
		String rol = request.getParameter("rol");	
		UserStore.createUsuario(nombre, passwd, apellidos, dirrecion, email, Integer.parseInt(rol));	
		return "home.jsp";
	}

}
