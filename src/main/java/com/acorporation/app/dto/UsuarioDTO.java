package com.acorporation.app.dto;

public class UsuarioDTO {

    private Integer idUsuario;
    private String nombreUsuario;
    private String nombreCompleto;
    private String email;
    private Boolean activo;
    private DepartamentoLiteDTO departamentoDocumento;
    private DepartamentoDTO departamento;
    private RolDTO rol;
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
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public DepartamentoLiteDTO getDepartamentoDocumento() {
		return departamentoDocumento;
	}
	public void setDepartamentoDocumento(DepartamentoLiteDTO departamentoDocumento) {
		this.departamentoDocumento = departamentoDocumento;
	}
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
	public RolDTO getRol() {
		return rol;
	}
	public void setRol(RolDTO rol) {
		this.rol = rol;
	}
	public UsuarioDTO(Integer idUsuario, String nombreUsuario, String nombreCompleto, String email, Boolean activo,
			DepartamentoLiteDTO departamentoDocumento, DepartamentoDTO departamento, RolDTO rol) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.activo = activo;
		this.departamentoDocumento = departamentoDocumento;
		this.departamento = departamento;
		this.rol = rol;
	}
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	

    
}