package com.acorporation.app.dto;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CotizacionDTO {

    private Integer idCotizacion;
    private Date fecha;
    private String codigo;
    private String terminosCondiciones;
    private BigDecimal subTotal;
    private BigDecimal igv;
    private BigDecimal total;
    private String cuentaEmpresa;
    private String cciEmpresa;
    private String bancoEmpresa;
    private String nombreUsuarioVenta;
    private ClienteDTO cliente;
    private String estado;
    private String observaciones;
    private UsuarioDTO usuario;
    private List<CotizacionProductoDTO> productos;
    
	public Integer getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(Integer idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTerminosCondiciones() {
		return terminosCondiciones;
	}
	public void setTerminosCondiciones(String terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public BigDecimal getIgv() {
		return igv;
	}
	public void setIgv(BigDecimal igv) {
		this.igv = igv;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCuentaEmpresa() {
		return cuentaEmpresa;
	}
	public void setCuentaEmpresa(String cuentaEmpresa) {
		this.cuentaEmpresa = cuentaEmpresa;
	}
	public String getCciEmpresa() {
		return cciEmpresa;
	}
	public void setCciEmpresa(String cciEmpresa) {
		this.cciEmpresa = cciEmpresa;
	}
	public String getBancoEmpresa() {
		return bancoEmpresa;
	}
	public void setBancoEmpresa(String bancoEmpresa) {
		this.bancoEmpresa = bancoEmpresa;
	}
	public String getNombreUsuarioVenta() {
		return nombreUsuarioVenta;
	}
	public void setNombreUsuarioVenta(String nombreUsuarioVenta) {
		this.nombreUsuarioVenta = nombreUsuarioVenta;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public List<CotizacionProductoDTO> getProductos() {
		return productos;
	}
	public void setProductos(List<CotizacionProductoDTO> productos) {
		this.productos = productos;
	}
	public CotizacionDTO(Integer idCotizacion, Date fecha, String codigo, String terminosCondiciones,
			BigDecimal subTotal, BigDecimal igv, BigDecimal total, String cuentaEmpresa, String cciEmpresa,
			String bancoEmpresa, String nombreUsuarioVenta, ClienteDTO cliente, String estado, String observaciones,
			UsuarioDTO usuario, List<CotizacionProductoDTO> productos) {
		super();
		this.idCotizacion = idCotizacion;
		this.fecha = fecha;
		this.codigo = codigo;
		this.terminosCondiciones = terminosCondiciones;
		this.subTotal = subTotal;
		this.igv = igv;
		this.total = total;
		this.cuentaEmpresa = cuentaEmpresa;
		this.cciEmpresa = cciEmpresa;
		this.bancoEmpresa = bancoEmpresa;
		this.nombreUsuarioVenta = nombreUsuarioVenta;
		this.cliente = cliente;
		this.estado = estado;
		this.observaciones = observaciones;
		this.usuario = usuario;
		this.productos = productos;
	}
	public CotizacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
}
