package com.acorporation.app.dto;

import java.util.Date;

public class EmpresaLiteDTO {
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String ruc;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaCreacion;
    private Boolean activo;
    
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public EmpresaLiteDTO(Integer idEmpresa, String nombreEmpresa, String ruc, String direccion, String telefono,
			String email, Date fechaCreacion, Boolean activo) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}
	public EmpresaLiteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpresaLiteDTO(Integer idEmpresa, String nombreEmpresa) {
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
	}
    
    
}
