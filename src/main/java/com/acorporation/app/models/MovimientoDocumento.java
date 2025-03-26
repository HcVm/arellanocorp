package com.acorporation.app.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "movimientosdocumentos")

public class MovimientoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_documento")
    private Documento documento;

    @ManyToOne
    @JoinColumn(name = "id_departamento_origen")
    private Departamento departamentoOrigen;

    @ManyToOne
    @JoinColumn(name = "id_departamento_destino")
    private Departamento departamentoDestino;

    @ManyToOne
    @JoinColumn(name = "id_usuario_envia")
    private Usuario usuarioEnvia;

    @ManyToOne
    @JoinColumn(name = "id_usuario_recibe")
    private Usuario usuarioRecibe;

    @Column(name = "fecha_movimiento")
    private Date fechaMovimiento;

    @Column(name = "comentarios")
    private String comentarios;

	public Integer getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Departamento getDepartamentoOrigen() {
		return departamentoOrigen;
	}

	public void setDepartamentoOrigen(Departamento departamentoOrigen) {
		this.departamentoOrigen = departamentoOrigen;
	}

	public Departamento getDepartamentoDestino() {
		return departamentoDestino;
	}

	public void setDepartamentoDestino(Departamento departamentoDestino) {
		this.departamentoDestino = departamentoDestino;
	}

	public Usuario getUsuarioEnvia() {
		return usuarioEnvia;
	}

	public void setUsuarioEnvia(Usuario usuarioEnvia) {
		this.usuarioEnvia = usuarioEnvia;
	}

	public Usuario getUsuarioRecibe() {
		return usuarioRecibe;
	}

	public void setUsuarioRecibe(Usuario usuarioRecibe) {
		this.usuarioRecibe = usuarioRecibe;
	}

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public MovimientoDocumento(Documento documento, Departamento departamentoOrigen, Departamento departamentoDestino,
			Usuario usuarioEnvia, Usuario usuarioRecibe, Date fechaMovimiento, String comentarios) {
		super();
		this.documento = documento;
		this.departamentoOrigen = departamentoOrigen;
		this.departamentoDestino = departamentoDestino;
		this.usuarioEnvia = usuarioEnvia;
		this.usuarioRecibe = usuarioRecibe;
		this.fechaMovimiento = fechaMovimiento;
		this.comentarios = comentarios;
	}

	public MovimientoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}