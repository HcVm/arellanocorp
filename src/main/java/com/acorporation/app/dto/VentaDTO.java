package com.acorporation.app.dto;

import java.math.BigDecimal;
import java.util.Date;

public class VentaDTO {

    private Integer idVenta;
    private String mes;
    private String semaforo;
    private String codigo;
    private String entrega;
    private String recibe;
    private DistribuidorDTO distribuidor; // Relación con DistribuidorDTO
    private ClienteDTO cliente; // Relación con ClienteDTO
    private String siaf;
    private String asunto;
    private Integer cantidad;
    private ProductoDTO producto; // Relación con ProductoDTO
    private String ocam;
    private String ordenFisica;
    private String numeroSiaf;
    private String unidadEjecutoraVenta;
    private String proyectoMeta;
    private String lugarDestino;
    private String derivadoArea1;
    private BigDecimal costoUnitario;
    private String pagos;
    private String creditoCash;
    private String plazoEntrega;
    private Date fecha;
    private String hora;
    private String estado;
    private String archivo;
    private String imagenReferencial;
    private String observaciones;
    private String nombreUsuarioVenta;
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEntrega() {
		return entrega;
	}
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}
	public String getRecibe() {
		return recibe;
	}
	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}
	public DistribuidorDTO getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(DistribuidorDTO distribuidor) {
		this.distribuidor = distribuidor;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public String getSiaf() {
		return siaf;
	}
	public void setSiaf(String siaf) {
		this.siaf = siaf;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}
	public String getOcam() {
		return ocam;
	}
	public void setOcam(String ocam) {
		this.ocam = ocam;
	}
	public String getOrdenFisica() {
		return ordenFisica;
	}
	public void setOrdenFisica(String ordenFisica) {
		this.ordenFisica = ordenFisica;
	}
	public String getNumeroSiaf() {
		return numeroSiaf;
	}
	public void setNumeroSiaf(String numeroSiaf) {
		this.numeroSiaf = numeroSiaf;
	}
	public String getUnidadEjecutoraVenta() {
		return unidadEjecutoraVenta;
	}
	public void setUnidadEjecutoraVenta(String unidadEjecutoraVenta) {
		this.unidadEjecutoraVenta = unidadEjecutoraVenta;
	}
	public String getProyectoMeta() {
		return proyectoMeta;
	}
	public void setProyectoMeta(String proyectoMeta) {
		this.proyectoMeta = proyectoMeta;
	}
	public String getLugarDestino() {
		return lugarDestino;
	}
	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}
	public String getDerivadoArea1() {
		return derivadoArea1;
	}
	public void setDerivadoArea1(String derivadoArea1) {
		this.derivadoArea1 = derivadoArea1;
	}
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public String getPagos() {
		return pagos;
	}
	public void setPagos(String pagos) {
		this.pagos = pagos;
	}
	public String getCreditoCash() {
		return creditoCash;
	}
	public void setCreditoCash(String creditoCash) {
		this.creditoCash = creditoCash;
	}
	public String getPlazoEntrega() {
		return plazoEntrega;
	}
	public void setPlazoEntrega(String plazoEntrega) {
		this.plazoEntrega = plazoEntrega;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getImagenReferencial() {
		return imagenReferencial;
	}
	public void setImagenReferencial(String imagenReferencial) {
		this.imagenReferencial = imagenReferencial;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getNombreUsuarioVenta() {
		return nombreUsuarioVenta;
	}
	public void setNombreUsuarioVenta(String nombreUsuarioVenta) {
		this.nombreUsuarioVenta = nombreUsuarioVenta;
	}
	public VentaDTO(Integer idVenta, String mes, String semaforo, String codigo, String entrega, String recibe,
			DistribuidorDTO distribuidor, ClienteDTO cliente, String siaf, String asunto, Integer cantidad,
			ProductoDTO producto, String ocam, String ordenFisica, String numeroSiaf, String unidadEjecutoraVenta,
			String proyectoMeta, String lugarDestino, String derivadoArea1, BigDecimal costoUnitario, String pagos,
			String creditoCash, String plazoEntrega, Date fecha, String hora, String estado, String archivo,
			String imagenReferencial, String observaciones, String nombreUsuarioVenta) {
		super();
		this.idVenta = idVenta;
		this.mes = mes;
		this.semaforo = semaforo;
		this.codigo = codigo;
		this.entrega = entrega;
		this.recibe = recibe;
		this.distribuidor = distribuidor;
		this.cliente = cliente;
		this.siaf = siaf;
		this.asunto = asunto;
		this.cantidad = cantidad;
		this.producto = producto;
		this.ocam = ocam;
		this.ordenFisica = ordenFisica;
		this.numeroSiaf = numeroSiaf;
		this.unidadEjecutoraVenta = unidadEjecutoraVenta;
		this.proyectoMeta = proyectoMeta;
		this.lugarDestino = lugarDestino;
		this.derivadoArea1 = derivadoArea1;
		this.costoUnitario = costoUnitario;
		this.pagos = pagos;
		this.creditoCash = creditoCash;
		this.plazoEntrega = plazoEntrega;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.archivo = archivo;
		this.imagenReferencial = imagenReferencial;
		this.observaciones = observaciones;
		this.nombreUsuarioVenta = nombreUsuarioVenta;
	}
	public VentaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}