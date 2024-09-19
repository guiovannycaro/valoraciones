package com.valoraciones.Models;

public class Clientes {

	Integer idCliente;
	Integer codCliente;
	String nombres;
	String fecha;
	String correo;

	
	public Clientes() {
	}

	

	public Clientes(Integer idCliente, Integer codCliente, String nombres, String fecha, String correo) {
		super();
		this.idCliente = idCliente;
		this.codCliente = codCliente;
		this.nombres = nombres;
		this.fecha = fecha;
		this.correo = correo;
	}



	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}



	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", codCliente=" + codCliente + ", nombres=" + nombres + ", fecha="
				+ fecha + ", correo=" + correo + "]";
	}



	
}
