package com.acorporation.app.dto;

import java.util.List;

public class ProductoDTO {

	private Integer idProducto;
    private String codigoProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private CatalogoElectronicoDTO catalogoElectronico;
    private Integer stock;
    private Boolean estado;
    private Double precioPlataforma;
    private MarcaDTO marca;
    private List<ValorCaracteristicaDTO> caracteristicas;
    
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public CatalogoElectronicoDTO getCatalogoElectronico() {
		return catalogoElectronico;
	}
	public void setCatalogoElectronico(CatalogoElectronicoDTO catalogoElectronico) {
		this.catalogoElectronico = catalogoElectronico;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Double getPrecioPlataforma() {
		return precioPlataforma;
	}
	public void setPrecioPlataforma(Double precioPlataforma) {
		this.precioPlataforma = precioPlataforma;
	}
	public MarcaDTO getMarca() {
		return marca;
	}
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	public List<ValorCaracteristicaDTO> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(List<ValorCaracteristicaDTO> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public ProductoDTO(Integer idProducto, String codigoProducto, String nombreProducto, String descripcionProducto,
			CatalogoElectronicoDTO catalogoElectronico, Integer stock, Boolean estado, Double precioPlataforma,
			MarcaDTO marca, List<ValorCaracteristicaDTO> caracteristicas) {
		super();
		this.idProducto = idProducto;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.catalogoElectronico = catalogoElectronico;
		this.stock = stock;
		this.estado = estado;
		this.precioPlataforma = precioPlataforma;
		this.marca = marca;
		this.caracteristicas = caracteristicas;
	}
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}