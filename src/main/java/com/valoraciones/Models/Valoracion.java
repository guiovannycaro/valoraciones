package com.valoraciones.Models;

public class Valoracion {
	Integer idValoracion;
	Integer idServicio;
	Integer IdCliente;
	Integer Puntuacion;

	public Valoracion() {

	}

	public Valoracion(Integer idValoracion, Integer idServicio, Integer idCliente, Integer puntuacion) {
		super();
		this.idValoracion = idValoracion;
		this.idServicio = idServicio;
		IdCliente = idCliente;
		Puntuacion = puntuacion;
	}

	public Integer getIdValoracion() {
		return idValoracion;
	}

	public void setIdValoracion(Integer idValoracion) {
		this.idValoracion = idValoracion;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public Integer getPuntuacion() {
		return Puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		Puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Valoracion [idValoracion=" + idValoracion + ", idServicio=" + idServicio + ", IdCliente=" + IdCliente
				+ ", Puntuacion=" + Puntuacion + "]";
	}

	
}
