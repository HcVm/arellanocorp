package com.acorporation.app.dto;

public class MarcaDTO {

    private Integer idMarca;
    private String nombreMarca;
    private String descripcion;
    private EmpresaDTO empresa;
    
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EmpresaDTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}
	public MarcaDTO(Integer idMarca, String nombreMarca, String descripcion, EmpresaDTO empresa) {
		super();
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}
	public MarcaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
