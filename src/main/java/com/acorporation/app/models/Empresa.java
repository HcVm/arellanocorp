package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "nombre_empresa", unique = true)
    private String nombreEmpresa;

    @Column(name = "ruc", unique = true)
    private String ruc;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "activo")
    private Boolean activo;

    @OneToMany(mappedBy = "empresa")
    private List<Departamento> departamentos;

    @OneToMany(mappedBy = "empresa")
    private Set<Marca> marcas;

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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Set<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(Set<Marca> marcas) {
		this.marcas = marcas;
	}

	public Empresa(String nombreEmpresa, String ruc, String direccion, String telefono, String email,
			Date fechaCreacion, Boolean activo, List<Departamento> departamentos, Set<Marca> marcas) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.ruc = ruc;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		this.departamentos = departamentos;
		this.marcas = marcas;
	}

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

	

    
}