package com.acorporation.app.dto;

public class ActualizarUsuarioDTO {
	
	private String nombreCompleto;
    private String nombreUsuario;
    private String email;
    
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ActualizarUsuarioDTO(String nombreCompleto, String nombreUsuario, String email) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
	}
	public ActualizarUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
