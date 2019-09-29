package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IHandlerCommand {

	public String execute(HttpServletRequest request, HttpServletResponse response);

}
