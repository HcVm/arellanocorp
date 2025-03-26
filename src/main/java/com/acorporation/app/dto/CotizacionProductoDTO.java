package com.acorporation.app.dto;

import java.math.BigDecimal;

public class CotizacionProductoDTO {
    
    private Integer idCotizacionProducto;
    private Integer cantidad;
    private String descripcion;
    private String unidad;
    private ProductoDTO producto;
    private BigDecimal importeUnitario;
    private BigDecimal importeTotal;
    
	public Integer getIdCotizacionProducto() {
		return idCotizacionProducto;
	}
	public void setIdCotizacionProducto(Integer idCotizacionProducto) {
		this.idCotizacionProducto = idCotizacionProducto;
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
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
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
	public CotizacionProductoDTO(Integer idCotizacionProducto, Integer cantidad, String descripcion, String unidad,
			ProductoDTO producto, BigDecimal importeUnitario, BigDecimal importeTotal) {
		super();
		this.idCotizacionProducto = idCotizacionProducto;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.producto = producto;
		this.importeUnitario = importeUnitario;
		this.importeTotal = importeTotal;
	}
	public CotizacionProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
        
    
}