package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.frontend.dao.UserStore;
import com.frontend.models.Usuario;

public class LoginCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
		
				throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String respuesta = "home";
		
		if(email!= null && passwd!=null) {	
				//Se cogen los datos de mail y contraseña introducidos
				Usuario usuario = UserStore.login(email, passwd); 
			
				//Si no está registrado el usuario devolvera null (los datos son incorrectos)
				if(usuario == null) {
					respuesta = "404";
				} 
				
				//Si está registrado el usuario le dejará iniciar sesion (los datos son correctos)
				else {
					HttpSession sesion = request.getSesion(true);
					sesion.setAttribute("user", usuario);
					respuesta = "home";
				}		
				
		} else { 
		respuesta = "login";
		}
		
		return respuesta;
	}

}
