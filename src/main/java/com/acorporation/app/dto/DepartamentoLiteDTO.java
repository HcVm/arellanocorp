package com.acorporation.app.dto;

public class DepartamentoLiteDTO {
    private Integer idDepartamento;
    private String nombreDepartamento;
    
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public DepartamentoLiteDTO(Integer idDepartamento, String nombreDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
	}
	public DepartamentoLiteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}
