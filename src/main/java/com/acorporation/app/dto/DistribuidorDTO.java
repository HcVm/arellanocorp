package com.acorporation.app.dto;

import java.util.Date;

public class DistribuidorDTO {
	
	private Integer idDistribuidor;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String celular;
    private String correo;
    private String contacto;
    private String observaciones;
    private Date fechaCreacion;
    private Boolean activo;
    
	public Integer getIdDistribuidor() {
		return idDistribuidor;
	}
	public void setIdDistribuidor(Integer idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	public DistribuidorDTO(Integer idDistribuidor, String ruc, String razonSocial, String direccion, String celular,
			String correo, String contacto, String observaciones, Date fechaCreacion, Boolean activo) {
		super();
		this.idDistribuidor = idDistribuidor;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.celular = celular;
		this.correo = correo;
		this.contacto = contacto;
		this.observaciones = observaciones;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
	}
	public DistribuidorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
