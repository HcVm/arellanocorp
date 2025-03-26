package com.acorporation.app.dto;

public class ValorCaracteristicaDTO {

    private Integer idValorCaracteristica;
    private Integer idCaracteristica;
    private String nombreCaracteristica;
    private String valor;

    public Integer getIdValorCaracteristica() {
        return idValorCaracteristica;
    }

    public void setIdValorCaracteristica(Integer idValorCaracteristica) {
        this.idValorCaracteristica = idValorCaracteristica;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
