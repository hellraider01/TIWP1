package com.frontend.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.CategoriaStore;
import com.frontend.models.Categoria;

public class VerLoginCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Categoria> categorias = CategoriaStore.getCategorias();
		request.setAttribute("categorias", categorias);
		return "login.jsp";
	}

}
