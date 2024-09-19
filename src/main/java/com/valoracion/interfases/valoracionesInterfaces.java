package com.valoracion.interfases;

import com.valoraciones.Models.Clientes;
import com.valoraciones.Models.Establecimiento;
import com.valoraciones.Models.EstablecimientoXServicio;
import com.valoraciones.Models.Servicio;
import com.valoraciones.Models.Usuarios;
import com.valoraciones.Models.Valoracion;

public interface valoracionesInterfaces {
	public int validarUsuario(String usuario, String clave);
	
	public int getPerfil(String usuario);
	public void cambioclave(String usuario, String clave);
	public int posicionUsuario(String usuario);
	public int posicionSevicio(String servicio);
	public int posicionEstablecimiento(String establecimiento);
	
	public int posicionCliente(String cliente);
	public int posicionContadorEstablecimientoXServicio(String estser);
	public int posicionValoracion(String valor);
	public String agregarUsuario(Usuarios miUsuario);
	public String agregarServicio(Servicio miServicio);
	public String agregarEstablecimiento(Establecimiento miEstablecimiento);
	public String agregarClientes(Clientes miCliente);
	public String agregarEstablecimientosXServicio(EstablecimientoXServicio miEstablecimientoXServicio);
	public String agregarClientes(Valoracion miValoracion);
	public String modificarUsuario(Usuarios miUsuario, int pos);
	public String modificarCliente(Clientes miCliente, int pos);
	public String borrarUsuario(int pos);
	public String borrarServicio(int pos);
	public String borrarEstablecimiento(int pos);
	public String borrarCliente(int pos);
	public String borrarEstablecimientoXServicio(int pos);
	public String borrarValoracion(int pos);
	public void GrabarTodo();
	public void GrabarUsuarios() ;
	public void GrabarServicios();
	public void GrabarEstablecimientos();
	public void GrabarClientes();
	public void GrabarEstablecimientoServicio();
	public void GrabarValoracion();
	public void cargarusuarios();
	public void cargarservicios();
	public void cargarestablecimientos();
	public void cargarclientes();
	public void cargarestablecimientosxservicio();
	public void cargarvaloracion();
	public String getUsuario(String usuario);
	
}
