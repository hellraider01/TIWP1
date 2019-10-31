package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.UserStore;

public class EliminarUsuarioCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int idSearch = Integer.parseInt(id);
		UserStore.eliminarUsuario(idSearch);
		return "home.jsp";
	}

}
