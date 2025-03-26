package com.acorporation.app.models;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cotizacionesproductos")
public class CotizacionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion_producto")
    private Integer idCotizacionProducto;

    @ManyToOne
    @JoinColumn(name = "id_cotizacion")
    private Cotizacion cotizacion;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "unidad")
    private String unidad;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    private Producto producto;

    @Column(name = "importe_unitario")
    private BigDecimal importeUnitario;

    @Column(name = "importe_total")
    private BigDecimal importeTotal;

	public Integer getIdCotizacionProducto() {
		return idCotizacionProducto;
	}

	public void setIdCotizacionProducto(Integer idCotizacionProducto) {
		this.idCotizacionProducto = idCotizacionProducto;
	}

	public Cotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public BigDecimal getImporteUnitario() {
		return importeUnitario;
	}

	public void setImporteUnitario(BigDecimal importeUnitario) {
		this.importeUnitario = importeUnitario;
	}

	public BigDecimal getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	public CotizacionProducto(Cotizacion cotizacion, Integer cantidad, String descripcion, String unidad,
			Producto producto, BigDecimal importeUnitario, BigDecimal importeTotal) {
		super();
		this.cotizacion = cotizacion;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.producto = producto;
		this.importeUnitario = importeUnitario;
		this.importeTotal = importeTotal;
	}

	public CotizacionProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}