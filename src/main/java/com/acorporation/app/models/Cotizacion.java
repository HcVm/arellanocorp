package com.acorporation.app.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cotizaciones")
public class Cotizacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Integer idCotizacion;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "terminos_condiciones")
    private String terminosCondiciones;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @Column(name = "igv")
    private BigDecimal igv;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "cuenta_empresa")
    private String cuentaEmpresa;

    @Column(name = "cci_empresa")
    private String cciEmpresa;

    @Column(name = "banco_empresa")
    private String bancoEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_usuario_venta")
    private Usuario usuarioVenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @Column(name = "estado")
    private String estado;

    @Column(name = "observaciones")
    private String observaciones;

    @OneToMany(mappedBy = "cotizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CotizacionProducto> productos;

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

	public Usuario getUsuarioVenta() {
		return usuarioVenta;
	}

	public void setUsuarioVenta(Usuario usuarioVenta) {
		this.usuarioVenta = usuarioVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public List<CotizacionProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<CotizacionProducto> productos) {
		this.productos = productos;
	}

	public Cotizacion(Date fecha, String codigo, String terminosCondiciones, BigDecimal subTotal, BigDecimal igv,
			BigDecimal total, String cuentaEmpresa, String cciEmpresa, String bancoEmpresa, Usuario usuarioVenta,
			Cliente cliente, String estado, String observaciones, List<CotizacionProducto> productos) {
		super();
		this.fecha = fecha;
		this.codigo = codigo;
		this.terminosCondiciones = terminosCondiciones;
		this.subTotal = subTotal;
		this.igv = igv;
		this.total = total;
		this.cuentaEmpresa = cuentaEmpresa;
		this.cciEmpresa = cciEmpresa;
		this.bancoEmpresa = bancoEmpresa;
		this.usuarioVenta = usuarioVenta;
		this.cliente = cliente;
		this.estado = estado;
		this.observaciones = observaciones;
		this.productos = productos;
	}

	public Cotizacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}