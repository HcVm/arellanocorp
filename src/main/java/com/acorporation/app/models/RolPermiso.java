package com.acorporation.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "rolespermisos")
public class RolPermiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_permiso")
    private Integer idRolPermiso;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_permiso")
    private Permiso permiso;

	public Integer getIdRolPermiso() {
		return idRolPermiso;
	}

	public void setIdRolPermiso(Integer idRolPermiso) {
		this.idRolPermiso = idRolPermiso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public RolPermiso(Rol rol, Permiso permiso) {
		super();
		this.rol = rol;
		this.permiso = permiso;
	}

	public RolPermiso() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}