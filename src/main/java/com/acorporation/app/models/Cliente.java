package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;

import com.acorporation.app.enums.TipoCliente;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

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

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipo;

    @Column(name = "unidad_ejecutora")
    private String unidadEjecutora;

    @Column(name = "encargado_almacen_entidad")
    private String encargadoAlmacenEntidad;

    @Column(name = "contacto_recogida_pedido")
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

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
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

	public Cliente(String ruc, String razonSocial, String direccion, String celular, String correo, String contacto,
			String observaciones, Date fechaCreacion, Boolean activo, TipoCliente tipo, String unidadEjecutora,
			String encargadoAlmacenEntidad, String contactoRecogidaPedido) {
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
		this.tipo = tipo;
		this.unidadEjecutora = unidadEjecutora;
		this.encargadoAlmacenEntidad = encargadoAlmacenEntidad;
		this.contactoRecogidaPedido = contactoRecogidaPedido;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}