package com.acorporation.app.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    @Column(name = "mes")
    private String mes;

    @Column(name = "semaforo")
    private String semaforo;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "entrega")
    private String entrega;

    @Column(name = "recibe")
    private String recibe;

    @ManyToOne
    @JoinColumn(name = "id_distribuidor")
    private Distribuidor distribuidor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "siaf")
    private String siaf;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    private Producto producto;

    @Column(name = "ocam")
    private String ocam;

    @Column(name = "orden_fisica")
    private String ordenFisica;

    @Column(name = "numero_siaf")
    private String numeroSiaf;

    @Column(name = "unidad_ejecutora_venta")
    private String unidadEjecutoraVenta;

    @Column(name = "proyecto_meta")
    private String proyectoMeta;

    @Column(name = "lugar_destino")
    private String lugarDestino;

    @Column(name = "derivado_area1")
    private String derivadoArea1;

    @Column(name = "costo_unitario")
    private BigDecimal costoUnitario;

    @Column(name = "pagos")
    private String pagos;

    @Column(name = "credito_cash")
    private String creditoCash;

    @Column(name = "plazo_entrega")
    private String plazoEntrega;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "archivo")
    private String archivo;

    @Column(name = "imagen_referencial")
    private String imagenReferencial;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_usuario_venta")
    private Usuario usuarioVenta;

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

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
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

	public Usuario getUsuarioVenta() {
		return usuarioVenta;
	}

	public void setUsuarioVenta(Usuario usuarioVenta) {
		this.usuarioVenta = usuarioVenta;
	}

	public Venta(String mes, String semaforo, String codigo, String entrega, String recibe, Distribuidor distribuidor,
			Cliente cliente, String siaf, String asunto, Integer cantidad, Producto producto, String ocam,
			String ordenFisica, String numeroSiaf, String unidadEjecutoraVenta, String proyectoMeta,
			String lugarDestino, String derivadoArea1, BigDecimal costoUnitario, String pagos, String creditoCash,
			String plazoEntrega, Date fecha, String hora, String estado, String archivo, String imagenReferencial,
			String observaciones, Usuario usuarioVenta) {
		super();
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
		this.usuarioVenta = usuarioVenta;
	}

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}