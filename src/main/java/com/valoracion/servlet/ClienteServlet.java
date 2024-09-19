package com.valoracion.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.valoraciones.controller.valoracionesController;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet(name = "/ClienteServlet", urlPatterns = { "/ClienteServlet" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		HttpSession session = request.getSession(false);
		Integer perfil = (Integer) session.getAttribute("usuario");

		System.err.println(perfil);

		try {

			if (accion != null) {

				switch (accion) {
				case "ingresar":
					Ingresar(request, response);
					break;
				case "redirigir":
					regresar(request, response, perfil);
					break;
				default:
					response.sendRedirect("index.jsp");
					break;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void Ingresar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		valoracionesController misDatos = new valoracionesController();

		this.getServletConfig().getServletContext().getRequestDispatcher("/app-admin/clientes.jsp").forward(request,
				response);

	}
	
	
	
	
	

	private void regresar(HttpServletRequest request, HttpServletResponse response, int perfil) throws Exception {
		valoracionesController misDatos = new valoracionesController();

		if (perfil == 1) {
			this.getServletConfig().getServletContext().getRequestDispatcher("/app-admin/administrador.jsp")
					.forward(request, response);
		}
		if (perfil == 2) {
			this.getServletConfig().getServletContext().getRequestDispatcher("/app-admin/empleado.jsp").forward(request,
					response);
		}
	}

}
