package com.frontend.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.CategoriaStore;
import com.frontend.dao.ProductStore;
import com.frontend.dao.UserStore;
import com.frontend.models.Product;
import com.frontend.service.ActualizarProductoCommand;
import com.frontend.service.ActualizarUsuarioCommand;
import com.frontend.service.BuscarProductosCommand;
import com.frontend.service.CrearProductoCommand;
import com.frontend.service.CrearUsuarioCommand;
import com.frontend.service.EliminarProductoCommand;
import com.frontend.service.EliminarUsuarioCommand;
import com.frontend.service.HomeCommand;
import com.frontend.service.IHandlerCommand;
import com.frontend.service.IrNuevoUsuarioCommand;
import com.frontend.service.LoginCommand;
import com.frontend.service.LogoutCommand;
import com.frontend.service.VerLoginCommand;
import com.frontend.service.VerProductoCommand;
import com.frontend.service.VerUsuariosCommand;
import com.frontend.service.irNuevoProductoCommand;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Url automaticas <comando, vista>
	HashMap<String, IHandlerCommand> vistas = new HashMap<String, IHandlerCommand>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// acciones de listar, ajustar archivo de referencia de cada "comando", metodos get
		vistas.put("home", new HomeCommand());
		vistas.put("verlogin", new VerLoginCommand());
		vistas.put("verproducto", new VerProductoCommand());
		vistas.put("buscarproductos", new BuscarProductosCommand());
		vistas.put("verusuaios", new VerUsuariosCommand());
		vistas.put("irnuevoproductos", new irNuevoProductoCommand());
		vistas.put("irnuevousuario", new IrNuevoUsuarioCommand());
		// acciones de crear, actualizar o eleiminar, metodo post
		vistas.put("logearse", new LoginCommand());
		vistas.put("logout", new LogoutCommand());
		vistas.put("crearproducto", new CrearProductoCommand());
		vistas.put("actualizarproducto", new ActualizarProductoCommand());
		vistas.put("eliminarproducto", new EliminarProductoCommand());
		vistas.put("crearusuario", new CrearUsuarioCommand());
		vistas.put("actualizarusuario", new ActualizarUsuarioCommand());
		vistas.put("eliminarusuario", new EliminarUsuarioCommand());
		
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ProductStore.init();
		UserStore.init();
		CategoriaStore.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		IHandlerCommand vista = (IHandlerCommand) vistas.get(accion);
		String webpage = "";
		if (vista != null) {
			webpage = vista.execute(request, response);
		} else {
			webpage = "404.jsp";
		}
		request.getRequestDispatcher(webpage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		IHandlerCommand vista = (IHandlerCommand) vistas.get(accion);
		String webpage = "";
		if (vista != null) {
			webpage = vista.execute(request, response);
		} else {
			webpage = "404.jsp";
		}
		request.getRequestDispatcher(webpage).forward(request, response);
	}

}
