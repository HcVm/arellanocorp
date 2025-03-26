package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena_hash")
    private String contrasenaHash;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean activo;


    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

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

	public String getContrasenaHash() {
		return contrasenaHash;
	}

	public void setContrasenaHash(String contrasenaHash) {
		this.contrasenaHash = contrasenaHash;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario(String nombreUsuario, String contrasenaHash, String nombreCompleto, String email, Date fechaCreacion,
			Boolean activo, Departamento departamento, Rol rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenaHash = contrasenaHash;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.activo = activo;
		this.departamento = departamento;
		this.rol = rol;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}