package com.acorporation.app.dto;

import java.util.Date;

public class ClienteDTO {
	
	private Integer idCliente;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String celular;
    private String correo;
    private String contacto;
    private String observaciones;
    private Date fechaCreacion;
    private Boolean activo;
    private String tipo;
    private String unidadEjecutora;
    private String encargadoAlmacenEntidad;
    private String contactoRecogidaPedido;
    
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUnidadEjecutora() {
		return unidadEjecutora;
	}
	public void setUnidadEjecutora(String unidadEjecutora) {
		this.unidadEjecutora = unidadEjecutora;
	}
	public String getEncargadoAlmacenEntidad() {
		return encargadoAlmacenEntidad;
	}
	public void setEncargadoAlmacenEntidad(String encargadoAlmacenEntidad) {
		this.encargadoAlmacenEntidad = encargadoAlmacenEntidad;
	}
	public String getContactoRecogidaPedido() {
		return contactoRecogidaPedido;
	}
	public void setContactoRecogidaPedido(String contactoRecogidaPedido) {
		this.contactoRecogidaPedido = contactoRecogidaPedido;
	}
	public ClienteDTO(Integer idCliente, String ruc, String razonSocial, String direccion, String celular,
			String correo, String contacto, String observaciones, Date fechaCreacion, Boolean activo, String tipo,
			String unidadEjecutora, String encargadoAlmacenEntidad, String contactoRecogidaPedido) {
		super();
		this.idCliente = idCliente;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.celular = celular;
		this.correo = correo;
		this.contacto = contacto;
		this.observaciones = observaciones;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		this.tipo = tipo;
		this.unidadEjecutora = unidadEjecutora;
		this.encargadoAlmacenEntidad = encargadoAlmacenEntidad;
		this.contactoRecogidaPedido = contactoRecogidaPedido;
	}
	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
