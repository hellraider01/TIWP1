package com.frontend.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.dao.ProductStore;
import com.frontend.models.Product;
import com.frontend.service.ActualizarProductoCommand;
import com.frontend.service.ActualizarUsuarioCommand;
import com.frontend.service.BuscarProductosCommand;
import com.frontend.service.CrearProductoCommand;
import com.frontend.service.CrearUsuarioCommand;
import com.frontend.service.EliminarProductoCommand;
import com.frontend.service.HomeCommand;
import com.frontend.service.IHandlerCommand;
import com.frontend.service.IrNuevoUsuarioCommand;
import com.frontend.service.LoginCommand;
import com.frontend.service.LogoutCommand;
import com.frontend.service.VerLoginCommand;
import com.frontend.service.VerProductosCommand;
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

	ProductStore ps = new ProductStore();
	List<Product> productos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// acciones de listar, ajustar archivo de referencia de cada "comando"
		vistas.put("home", new HomeCommand());
		vistas.put("verlogin", new VerLoginCommand());
		vistas.put("verProductos", new VerProductosCommand());
		vistas.put("buscarProductos", new BuscarProductosCommand());
		vistas.put("verusuaios", new VerUsuariosCommand());
		vistas.put("irNuevoProductos", new irNuevoProductoCommand());
		vistas.put("irNuevoUsuario", new IrNuevoUsuarioCommand());
		// acciones de crear, actualizar o eleiminar
		vistas.put("logearse", new LoginCommand());
		vistas.put("logout", new LogoutCommand());
		vistas.put("crearProducto", new CrearProductoCommand());
		vistas.put("actualizarProducto", new ActualizarProductoCommand());
		vistas.put("eliminarProducto", new EliminarProductoCommand());
		vistas.put("crearUsuario", new CrearUsuarioCommand());
		vistas.put("actualizarUsuario", new ActualizarUsuarioCommand());

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		productos = ps.init();

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
		IHandlerCommand vista = vistas.get(accion);
		String webpage = "";
		if (vista != null) {
			webpage = vista.execute(request, response);
		} else {
			webpage = "404.jsp";
		}
		request.getRequestDispatcher(webpage).forward(request, response);
	}

}
