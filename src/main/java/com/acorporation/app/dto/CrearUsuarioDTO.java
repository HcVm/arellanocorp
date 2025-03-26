package com.acorporation.app.dto;

public class CrearUsuarioDTO {
	
	private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private Integer idDepartamento;
    private String email;
    private Integer idRol;
    
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public CrearUsuarioDTO(String nombreUsuario, String contrasena, String nombreCompleto, Integer idDepartamento,
			String email, Integer idRol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombreCompleto = nombreCompleto;
		this.idDepartamento = idDepartamento;
		this.email = email;
		this.idRol = idRol;
	}
	public CrearUsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


}
