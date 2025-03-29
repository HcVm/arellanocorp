package com.acorporation.app.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "codigo_producto", unique = true)
    private String codigoProducto;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @ManyToOne
    @JoinColumn(name = "id_catalogo")
    private CatalogoElectronico catalogoElectronico;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "precio_plataforma")
    private Double precioPlataforma;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    
    @ManyToMany
    @JoinTable(
            name = "productocaracteristicavalor",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_valor_caracteristica")
    )
    private List<ValorCaracteristica> caracteristicas = new ArrayList<>();

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public CatalogoElectronico getCatalogoElectronico() {
		return catalogoElectronico;
	}

	public void setCatalogoElectronico(CatalogoElectronico catalogoElectronico) {
		this.catalogoElectronico = catalogoElectronico;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Double getPrecioPlataforma() {
		return precioPlataforma;
	}

	public void setPrecioPlataforma(Double precioPlataforma) {
		this.precioPlataforma = precioPlataforma;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<ValorCaracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<ValorCaracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Producto(Integer idProducto, String codigoProducto, String nombreProducto, String descripcionProducto,
			CatalogoElectronico catalogoElectronico, Integer stock, Boolean estado, Double precioPlataforma,
			Marca marca) {
		super();
		this.idProducto = idProducto;
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.catalogoElectronico = catalogoElectronico;
		this.stock = stock;
		this.estado = estado;
		this.precioPlataforma = precioPlataforma;
		this.marca = marca;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCaracteristica(ValorCaracteristica valorCaracteristica) {
	    this.caracteristicas.add(valorCaracteristica);
	    valorCaracteristica.getProductos().add(this); // Asegurar la bidireccionalidad
	}

	
	public void removeCaracteristica(ValorCaracteristica valorCaracteristica) {
	    if (this.caracteristicas != null) {
	        this.caracteristicas.remove(valorCaracteristica);
	    }
	}

	
}