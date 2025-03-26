package com.acorporation.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "valorescaracteristica")

public class ValorCaracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor_caracteristica")
    private Integer idValorCaracteristica;

    @ManyToOne
    @JoinColumn(name = "id_caracteristica")
    private Caracteristica caracteristica;

    @Column(name = "valor")
    private String valor;

	public Integer getIdValorCaracteristica() {
		return idValorCaracteristica;
	}

	public void setIdValorCaracteristica(Integer idValorCaracteristica) {
		this.idValorCaracteristica = idValorCaracteristica;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public ValorCaracteristica(Caracteristica caracteristica, String valor) {
		super();
		this.caracteristica = caracteristica;
		this.valor = valor;
	}

	public ValorCaracteristica() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}