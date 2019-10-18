package com.frontend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.models.Usuario;

public class LoginCommand implements IHandlerCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
		
				throws ServletException, IOException {
			
		if(request.getEmail() != null) {	
				//Se cogen los datos de mail y contraseña introducidos
				Usuario nuevousuario = new Usuario(); 
				nuevousuario.setEmail(request.getEmail());
				nuevousuario.setPasswd(request.getPasswd());
			
				//Se comprueba si el usuario está registrado
				Usuario user = webResource.request().accept(" ").post(Entity.entity(nuevousuario, MediaType.APPLICATION_JSON_TYPE),Usuario.class);
				
				//Si no está registrado el usuario devolvera null (los datos son incorrectos)
				if(user == null) {
					response.sendRedirect(" ");
				} 
				//Si está registrado el usuario le dejará iniciar sesion (los datos son correctos)
				else {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
					response.sendRedirect(" ");
				}
							
							
				return null;
			}
			
		
		return "login.jsp";
	}

}
