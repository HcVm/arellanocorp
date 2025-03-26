package com.acorporation.app.dto;

import java.util.Date;

public class CatalogoElectronicoDTO {

    private Integer idCatalogo;
    private String codigoCatalogo;
    private String descripcionCatalogo;
    private Date fechaCreacion;
    private AcuerdoMarcoDTO acuerdoMarco;
    
	public Integer getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getCodigoCatalogo() {
		return codigoCatalogo;
	}
	public void setCodigoCatalogo(String codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}
	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}
	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public AcuerdoMarcoDTO getAcuerdoMarco() {
		return acuerdoMarco;
	}
	public void setAcuerdoMarco(AcuerdoMarcoDTO acuerdoMarco) {
		this.acuerdoMarco = acuerdoMarco;
	}
	public CatalogoElectronicoDTO(Integer idCatalogo, String codigoCatalogo, String descripcionCatalogo,
			Date fechaCreacion, AcuerdoMarcoDTO acuerdoMarco) {
		super();
		this.idCatalogo = idCatalogo;
		this.codigoCatalogo = codigoCatalogo;
		this.descripcionCatalogo = descripcionCatalogo;
		this.fechaCreacion = fechaCreacion;
		this.acuerdoMarco = acuerdoMarco;
	}
	public CatalogoElectronicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}