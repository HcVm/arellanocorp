package com.acorporation.app.dto;

import java.util.Date;
import java.util.List;

public class DocumentoDTO {
    private Integer idDocumento;
    private String tipoDocumento;
    private String numeroDocumento;
    private Date fechaDocumento;
    private String rutaArchivo;
    private DepartamentoLiteDTO departamentoActual;
    private UsuarioDTO usuarioActual;
    private List<MovimientoDocumentoDTO> movimientos;
    
	public Integer getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Date getFechaDocumento() {
		return fechaDocumento;
	}
	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public String getRutaArchivo() {
		return rutaArchivo;
	}
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}
	public DepartamentoLiteDTO getDepartamentoActual() {
		return departamentoActual;
	}
	public void setDepartamentoActual(DepartamentoLiteDTO departamentoActual) {
		this.departamentoActual = departamentoActual;
	}
	public UsuarioDTO getUsuarioActual() {
		return usuarioActual;
	}
	public void setUsuarioActual(UsuarioDTO usuarioDTO) {
		this.usuarioActual = usuarioDTO;
	}
	public List<MovimientoDocumentoDTO> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<MovimientoDocumentoDTO> movimientos) {
		this.movimientos = movimientos;
	}
	public DocumentoDTO(Integer idDocumento, String tipoDocumento, String numeroDocumento, Date fechaDocumento,
			String rutaArchivo, DepartamentoLiteDTO departamentoActual, UsuarioDTO usuarioActual,
			List<MovimientoDocumentoDTO> movimientos) {
		super();
		this.idDocumento = idDocumento;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaDocumento = fechaDocumento;
		this.rutaArchivo = rutaArchivo;
		this.departamentoActual = departamentoActual;
		this.usuarioActual = usuarioActual;
		this.movimientos = movimientos;
	}
	public DocumentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocumentoDTO(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}
	
	
    
}
