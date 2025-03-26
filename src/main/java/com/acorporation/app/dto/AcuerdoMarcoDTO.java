package com.acorporation.app.dto;

import java.util.Date;

public class AcuerdoMarcoDTO {
	
	private Integer idAcuerdo;
    private String codigoAcuerdo;
    private String nombreAcuerdo;
    private Date fechaInicio;
    private Date fechaFin;
    
	public Integer getIdAcuerdo() {
		return idAcuerdo;
	}
	public void setIdAcuerdo(Integer idAcuerdo) {
		this.idAcuerdo = idAcuerdo;
	}
	public String getCodigoAcuerdo() {
		return codigoAcuerdo;
	}
	public void setCodigoAcuerdo(String codigoAcuerdo) {
		this.codigoAcuerdo = codigoAcuerdo;
	}
	public String getNombreAcuerdo() {
		return nombreAcuerdo;
	}
	public void setNombreAcuerdo(String nombreAcuerdo) {
		this.nombreAcuerdo = nombreAcuerdo;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public AcuerdoMarcoDTO(Integer idAcuerdo, String codigoAcuerdo, String nombreAcuerdo, Date fechaInicio,
			Date fechaFin) {
		super();
		this.idAcuerdo = idAcuerdo;
		this.codigoAcuerdo = codigoAcuerdo;
		this.nombreAcuerdo = nombreAcuerdo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public AcuerdoMarcoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
