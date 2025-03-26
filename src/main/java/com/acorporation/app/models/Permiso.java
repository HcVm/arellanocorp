package com.acorporation.app.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Permisos")

public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Integer idPermiso;

    @Column(name = "nombre_permiso")
    private String nombrePermiso;
    
    @OneToMany(mappedBy = "permiso", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RolPermiso> rolPermisos = new HashSet<>();

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getNombrePermiso() {
		return nombrePermiso;
	}

	public void setNombrePermiso(String nombrePermiso) {
		this.nombrePermiso = nombrePermiso;
	}

	public Set<RolPermiso> getRolPermisos() {
		return rolPermisos;
	}

	public void setRolPermisos(Set<RolPermiso> rolPermisos) {
		this.rolPermisos = rolPermisos;
	}

	public Permiso(String nombrePermiso, Set<RolPermiso> rolPermisos) {
		super();
		this.nombrePermiso = nombrePermiso;
		this.rolPermisos = rolPermisos;
	}

	public Permiso() {
		super();
		// TODO Auto-generated constructor stub
	}

	    
}