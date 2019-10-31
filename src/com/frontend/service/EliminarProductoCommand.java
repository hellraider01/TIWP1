package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.ProductStore;
import com.frontend.dao.UserStore;

public class EliminarProductoCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int idSearch = Integer.parseInt(id);
		ProductStore.eliminarProduct(idSearch);
		return "home.jsp";
	}

}
