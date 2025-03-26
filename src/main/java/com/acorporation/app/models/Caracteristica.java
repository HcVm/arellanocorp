package com.acorporation.app.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristica")
    private Integer idCaracteristica;

    @Column(name = "nombre_caracteristica")
    private String nombreCaracteristica;
    
    @OneToMany(mappedBy = "caracteristica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ValorCaracteristica> valores = new ArrayList<>();

	public Integer getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(Integer idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public String getNombreCaracteristica() {
		return nombreCaracteristica;
	}

	public void setNombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}

	public List<ValorCaracteristica> getValores() {
		return valores;
	}

	public void setValores(List<ValorCaracteristica> valores) {
		this.valores = valores;
	}

	public Caracteristica(String nombreCaracteristica, List<ValorCaracteristica> valores) {
		super();
		this.nombreCaracteristica = nombreCaracteristica;
		this.valores = valores;
	}

	public Caracteristica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}