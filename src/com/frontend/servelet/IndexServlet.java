package com.frontend.servelet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontend.models.Product;
import com.frontend.servicio.ProductStore;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Url automaticas <comando, vista>
	HashMap<String, String> vistas = new HashMap<String, String>();

	ProductStore ps = new ProductStore();
	List<Product> productos;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// acciones de listar
		vistas.put("home", "home.jsp");
		vistas.put("verlogin", "login.jsp");
		vistas.put("verProductos", "pages/single-product.jsp");
		vistas.put("buscarProductos", "pages/single-product.jsp");
		vistas.put("verusuaios", "pages/single-product.jsp");
		// acciones de crear, actualizar o eleiminar
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
		String view = vistas.get(accion);
		System.out.print(view);
		if (view == null) {
			view = "404.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			System.out.println(view);
			switch (accion) {
			case "home":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "verlogin":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "verProductos":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "verusuaios":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "buscarProductos":
				// codigo de accion con el Storage
				System.out.println(request.getParameter("nombre"));
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "irNuevoProductos":
				// codigo de accion con el Storage
				System.out.println(request.getParameter("nombre"));
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "irNuevoUsuario":
				// codigo de accion con el Storage
				System.out.println(request.getParameter("nombre"));
				request.getRequestDispatcher(view).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		String view = vistas.get(accion);
		if (view == null) {
			view = "404.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			System.out.println(view);
			switch (accion) {
			case "home":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "logearse":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "logout":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "crearProducto":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "actualizarProducto":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "eliminarProducto":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "crearUsuario":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "actualizarUsuario":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			case "eliminarUsuario":
				// codigo de accion con el Storage
				request.getRequestDispatcher(view).forward(request, response);
				break;
			default:
				request.getRequestDispatcher(view).forward(request, response);
			}
		}
	}

}
