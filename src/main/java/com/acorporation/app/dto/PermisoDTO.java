package com.acorporation.app.dto;

public class PermisoDTO {
	private Integer idPermiso;
    private String nombrePermiso;
    
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
	public PermisoDTO(Integer idPermiso, String nombrePermiso) {
		super();
		this.idPermiso = idPermiso;
		this.nombrePermiso = nombrePermiso;
	}
	public PermisoDTO() {
		super();
	}
    
    
}
