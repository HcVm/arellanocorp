package com.acorporation.app.dto;

import java.util.Set;

public class CrearRolDTO {
    private String nombreRol;
    private Set<Integer> permisos;
    
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public Set<Integer> getPermisos() {
		return permisos;
	}
	public void setPermisos(Set<Integer> permisos) {
		this.permisos = permisos;
	}
	public CrearRolDTO(String nombreRol, Set<Integer> permisos) {
		super();
		this.nombreRol = nombreRol;
		this.permisos = permisos;
	}
	public CrearRolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	  
}