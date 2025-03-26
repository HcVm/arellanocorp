package com.acorporation.app.dto;

public class UsuarioLiteDTO {
    private Integer idUsuario;
    private String nombreUsuario;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public UsuarioLiteDTO(Integer idUsuario, String nombreUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
	}
	public UsuarioLiteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
