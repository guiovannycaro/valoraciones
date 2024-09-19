package com.valoraciones.Models;

public class Usuarios {

	Integer IdUsuario;
	String usuario;
	String nombres;
	String correo;
	Integer Perfil;
	String password;
	
	public Usuarios() {

	}
	
	
	public Usuarios(Integer idUsuario, String usuario, String nombres, String correo, Integer perfil, String password) {
		IdUsuario = idUsuario;
		this.usuario = usuario;
		this.nombres = nombres;
		this.correo = correo;
		Perfil = perfil;
		this.password = password;
	}


	public Integer getIdUsuario() {
		return IdUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Integer getPerfil() {
		return Perfil;
	}


	public void setPerfil(Integer perfil) {
		Perfil = perfil;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuarios [IdUsuario=" + IdUsuario + ", usuario=" + usuario + ", nombres=" + nombres + ", correo="
				+ correo + ", Perfil=" + Perfil + ", password=" + password + "]";
	}
	
	
	
	
	
}
