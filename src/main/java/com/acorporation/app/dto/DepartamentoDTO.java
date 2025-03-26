package com.acorporation.app.dto;

public class DepartamentoDTO {
	
	private Integer idDepartamento;
    private String nombreDepartamento;
    private EmpresaLiteDTO empresa;
    
    
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
	public EmpresaLiteDTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaLiteDTO empresa) {
		this.empresa = empresa;
	}
	public DepartamentoDTO(Integer idDepartamento, String nombreDepartamento, EmpresaLiteDTO empresa) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.empresa = empresa;
	}
	public DepartamentoDTO(Integer idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }
	public DepartamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
