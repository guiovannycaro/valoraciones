package com.valoraciones.Models;

public class EstablecimientoXServicio {

	Integer IdEstablecimientoServicio;
	Integer IdEstablecimiento;
	Integer IdValoracion;
	
	public EstablecimientoXServicio() {
	
	}

	public EstablecimientoXServicio(Integer idEstablecimientoServicio, Integer idEstablecimiento,
			Integer idValoracion) {
		super();
		IdEstablecimientoServicio = idEstablecimientoServicio;
		IdEstablecimiento = idEstablecimiento;
		IdValoracion = idValoracion;
	}

	public Integer getIdEstablecimientoServicio() {
		return IdEstablecimientoServicio;
	}

	public void setIdEstablecimientoServicio(Integer idEstablecimientoServicio) {
		IdEstablecimientoServicio = idEstablecimientoServicio;
	}

	public Integer getIdEstablecimiento() {
		return IdEstablecimiento;
	}

	public void setIdEstablecimiento(Integer idEstablecimiento) {
		IdEstablecimiento = idEstablecimiento;
	}

	public Integer getIdValoracion() {
		return IdValoracion;
	}

	public void setIdValoracion(Integer idValoracion) {
		IdValoracion = idValoracion;
	}

	@Override
	public String toString() {
		return "EstablecimientoXServicio [IdEstablecimientoServicio=" + IdEstablecimientoServicio
				+ ", IdEstablecimiento=" + IdEstablecimiento + ", IdValoracion=" + IdValoracion + "]";
	}
	
	
	
	
}
