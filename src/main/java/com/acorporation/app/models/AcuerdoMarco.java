package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "acuerdosmarco")
public class AcuerdoMarco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acuerdo")
    private Integer idAcuerdo;

    @Column(name = "codigo_acuerdo")
    private String codigoAcuerdo;

    @Column(name = "nombre_acuerdo")
    private String nombreAcuerdo;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
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

	public AcuerdoMarco(String codigoAcuerdo, String nombreAcuerdo, Date fechaInicio, Date fechaFin) {
		super();
		this.codigoAcuerdo = codigoAcuerdo;
		this.nombreAcuerdo = nombreAcuerdo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public AcuerdoMarco() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
}