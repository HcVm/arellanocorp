package com.acorporation.app.dto;

import java.util.Set;

public class RolDTO {
    private Integer idRol;
    private String nombreRol;
    private Set<PermisoDTO> permisos;
    
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public Set<PermisoDTO> getPermisos() {
		return permisos;
	}
	public void setPermisos(Set<PermisoDTO> permisos) {
		this.permisos = permisos;
	}
	public RolDTO(Integer idRol, String nombreRol, Set<PermisoDTO> permisos) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.permisos = permisos;
	}
	public RolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RolDTO(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
 
	

}
