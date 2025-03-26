package com.acorporation.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productocaracteristicavalor")

public class ProductoCaracteristicaValor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_caracteristica_valor")
    private Integer idProductoCaracteristicaValor;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_valor_caracteristica")
    private ValorCaracteristica valorCaracteristica;

	public Integer getIdProductoCaracteristicaValor() {
		return idProductoCaracteristicaValor;
	}

	public void setIdProductoCaracteristicaValor(Integer idProductoCaracteristicaValor) {
		this.idProductoCaracteristicaValor = idProductoCaracteristicaValor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ValorCaracteristica getValorCaracteristica() {
		return valorCaracteristica;
	}

	public void setValorCaracteristica(ValorCaracteristica valorCaracteristica) {
		this.valorCaracteristica = valorCaracteristica;
	}

	public ProductoCaracteristicaValor(Producto producto, ValorCaracteristica valorCaracteristica) {
		super();
		this.producto = producto;
		this.valorCaracteristica = valorCaracteristica;
	}

	public ProductoCaracteristicaValor() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}