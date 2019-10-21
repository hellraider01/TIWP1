package com.frontend.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements IHandlerCommand {

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSesion sesion = request.getSesion(false);
		sesion.invalidate();
		
		return Contract.URL_LOGIN;
	}

}

