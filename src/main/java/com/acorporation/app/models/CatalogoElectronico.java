package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "catalogoselectronicos")
public class CatalogoElectronico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Integer idCatalogo;

    @Column(name = "codigo_catalogo")
    private String codigoCatalogo;

    @Column(name = "descripcion_catalogo")
    private String descripcionCatalogo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_acuerdo")
    private AcuerdoMarco acuerdoMarco;

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

	public AcuerdoMarco getAcuerdoMarco() {
		return acuerdoMarco;
	}

	public void setAcuerdoMarco(AcuerdoMarco acuerdoMarco) {
		this.acuerdoMarco = acuerdoMarco;
	}

	public CatalogoElectronico(String codigoCatalogo, String descripcionCatalogo, Date fechaCreacion,
			AcuerdoMarco acuerdoMarco) {
		super();
		this.codigoCatalogo = codigoCatalogo;
		this.descripcionCatalogo = descripcionCatalogo;
		this.fechaCreacion = fechaCreacion;
		this.acuerdoMarco = acuerdoMarco;
	}

	public CatalogoElectronico() {
		super();
		// TODO Auto-generated constructor stub
	}
}