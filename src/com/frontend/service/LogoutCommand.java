package com.frontend.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.frontend.dao.UserStore;

public class LogoutCommand implements IHandlerCommand {

	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSesion sesion = request.getSesion(false);
		sesion.invalidate();
		//sesion.removeAttribute("user");

		return "home";
	}

}

