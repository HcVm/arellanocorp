package com.acorporation.app.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "distribuidores")
public class Distribuidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distribuidor")
    private Integer idDistribuidor;

    @Column(name = "ruc", unique = true)
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contacto")
    private String contacto;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "activo")
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

	public Distribuidor(String ruc, String razonSocial, String direccion, String celular, String correo,
			String contacto, String observaciones, Date fechaCreacion, Boolean activo) {
		super();
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

	public Distribuidor() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}