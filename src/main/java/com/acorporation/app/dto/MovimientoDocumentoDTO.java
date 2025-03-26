package com.acorporation.app.dto;

import java.util.Date;

public class MovimientoDocumentoDTO {
    private Integer idMovimiento;
    private DocumentoDTO documento;
    private DepartamentoLiteDTO departamentoOrigen;
    private DepartamentoLiteDTO departamentoDestino;
    private UsuarioLiteDTO usuarioEnvia;
    private UsuarioLiteDTO usuarioRecibe;
    private Date fechaMovimiento;
    private String comentarios;

    // ✅ Constructor con todos los campos
    public MovimientoDocumentoDTO(Integer idMovimiento, DocumentoDTO documento, 
                                  DepartamentoLiteDTO departamentoOrigen, DepartamentoLiteDTO departamentoDestino,
                                  UsuarioLiteDTO usuarioEnvia, UsuarioLiteDTO usuarioRecibe,
                                  Date fechaMovimiento, String comentarios) {
        this.idMovimiento = idMovimiento;
        this.documento = documento;
        this.departamentoOrigen = departamentoOrigen;
        this.departamentoDestino = departamentoDestino;
        this.usuarioEnvia = usuarioEnvia;
        this.usuarioRecibe = usuarioRecibe;
        this.fechaMovimiento = fechaMovimiento;
        this.comentarios = comentarios;
    }

    public MovimientoDocumentoDTO() {
		// TODO Auto-generated constructor stub
	}

	// ✅ Getters y Setters
    public Integer getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(Integer idMovimiento) { this.idMovimiento = idMovimiento; }

    public DocumentoDTO getDocumento() { return documento; }
    public void setDocumento(DocumentoDTO documento) { this.documento = documento; }

    public DepartamentoLiteDTO getDepartamentoOrigen() { return departamentoOrigen; }
    public void setDepartamentoOrigen(DepartamentoLiteDTO departamentoOrigen) { this.departamentoOrigen = departamentoOrigen; }

    public DepartamentoLiteDTO getDepartamentoDestino() { return departamentoDestino; }
    public void setDepartamentoDestino(DepartamentoLiteDTO departamentoDestino) { this.departamentoDestino = departamentoDestino; }

    public UsuarioLiteDTO getUsuarioEnvia() { return usuarioEnvia; }
    public void setUsuarioEnvia(UsuarioLiteDTO usuarioEnvia) { this.usuarioEnvia = usuarioEnvia; }

    public UsuarioLiteDTO getUsuarioRecibe() { return usuarioRecibe; }
    public void setUsuarioRecibe(UsuarioLiteDTO usuarioRecibe) { this.usuarioRecibe = usuarioRecibe; }

    public Date getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(Date fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }
}
