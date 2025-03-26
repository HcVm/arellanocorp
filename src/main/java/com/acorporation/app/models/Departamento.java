package com.acorporation.app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "id_empresa") 
    private Empresa empresa;

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Departamento(String nombreDepartamento, Empresa empresa) {
		super();
		this.nombreDepartamento = nombreDepartamento;
		this.empresa = empresa;
	}

	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}