package com.acorporation.app.dto;

public class MoverDocumentoDTO {
    private Integer idDocumento;
    private Integer idDepartamentoDestino;
    private Integer idUsuarioRecibe;
    private String comentarios;

    // Constructor vacío
    public MoverDocumentoDTO() {}

    // Constructor con parámetros
    public MoverDocumentoDTO(Integer idDocumento, Integer idDepartamentoDestino, Integer idUsuarioRecibe, String comentarios) {
        this.idDocumento = idDocumento;
        this.idDepartamentoDestino = idDepartamentoDestino;
        this.idUsuarioRecibe = idUsuarioRecibe;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Integer getIdDepartamentoDestino() {
        return idDepartamentoDestino;
    }

    public void setIdDepartamentoDestino(Integer idDepartamentoDestino) {
        this.idDepartamentoDestino = idDepartamentoDestino;
    }

    public Integer getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    public void setIdUsuarioRecibe(Integer idUsuarioRecibe) {
        this.idUsuarioRecibe = idUsuarioRecibe;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
