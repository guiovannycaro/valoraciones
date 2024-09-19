package com.valoraciones.Models;

public class Establecimiento {
	Integer IdEstablecimiento;
	String nombre;
	String direccion;
	String telefono;
	
	public Establecimiento() {
		
	}
	
	public Establecimiento(Integer idEstablecimiento, String nombre, String direccion, String telefono) {
		
		IdEstablecimiento = idEstablecimiento;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getIdEstablecimiento() {
		return IdEstablecimiento;
	}

	public void setIdEstablecimiento(Integer idEstablecimiento) {
		IdEstablecimiento = idEstablecimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Establecimiento [IdEstablecimiento=" + IdEstablecimiento + ", nombre=" + nombre + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	
}
