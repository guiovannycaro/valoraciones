package com.valoracion.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.valoraciones.controller.valoracionesController;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SeguridadServlet
 */
@WebServlet(name = "SeguridadServlet", urlPatterns = { "/SeguridadServlet" })
public class SeguridadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeguridadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		valoracionesController misDatos = new valoracionesController();
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");

		try {

			if (accion != null) {
				
				
				switch (accion) {
				case "verificar":
					verificar(request,response);
					break;
				case "cerrar":
					cerrarsession(request,response);
					break;
				default:
					response.sendRedirect("index.jsp");
					break;
				}
		
			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			try {
				this.getServletConfig().getServletContext().getRequestDispatcher("/mensaje.jsp")
				.forward(request, response);
			} catch (Exception p) {
				System.err.println("Error" + p.getMessage());
			}
		}

	}
	
	private void verificar(HttpServletRequest request,HttpServletResponse response) throws Exception{
		valoracionesController misDatos = new valoracionesController();
		HttpSession session;
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		int perfil = misDatos.validarUsuario(usuario, contrasena);
		
		if(perfil == 1  ) {
			session = request.getSession();
			session.setAttribute("usuario", perfil);
			request.setAttribute("msje", "Bienvenido Al Sistema");
			
			this.getServletConfig().getServletContext().getRequestDispatcher("/app-admin/administrador.jsp").forward(request, response);

		}else if(perfil == 2) {
			this.getServletConfig().getServletContext().getRequestDispatcher("/app-admin/empleado.jsp").forward(request, response);

		}else {
			request.setAttribute("mensajeerror", "Credenciales Invalidas");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private void cerrarsession(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		session.setAttribute("usuario", null);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}
