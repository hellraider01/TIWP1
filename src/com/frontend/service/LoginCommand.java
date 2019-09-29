package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "login.jsp";
	}

}
