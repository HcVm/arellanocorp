package com.acorporation.app.dto;

import java.util.List;

public class CaracteristicaDTO {
    
    private Integer idCaracteristica;
    private String nombreCaracteristica;
    private List<ValorCaracteristicaDTO> valores;
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
	public List<ValorCaracteristicaDTO> getValores() {
		return valores;
	}
	public void setValores(List<ValorCaracteristicaDTO> valores) {
		this.valores = valores;
	}
	public CaracteristicaDTO(Integer idCaracteristica, String nombreCaracteristica,
			List<ValorCaracteristicaDTO> valores) {
		super();
		this.idCaracteristica = idCaracteristica;
		this.nombreCaracteristica = nombreCaracteristica;
		this.valores = valores;
	}
	public CaracteristicaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
