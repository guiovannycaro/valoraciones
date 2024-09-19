package com.valoraciones.Models;

public class Servicio {
 
	Integer idServicio;
    String nombre;
    String detalle;
    
	public Servicio() {
		
	}
    
	public Servicio(Integer idServicio, String nombre, String detalle) {
		this.idServicio = idServicio;
		this.nombre = nombre;
		this.detalle = detalle;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", detalle=" + detalle + "]";
	}
	
	
    
    
 
}
