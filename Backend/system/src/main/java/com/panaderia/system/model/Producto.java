package com.panaderia.system.model;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    @JsonIgnore
    private Set<DetalleVenta> ventas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    @JsonIgnore
    private Set<DetalleCompra> compras = new HashSet<>();

    private String nombre;
    private String descripcion;
    private Integer stock;
    private float preciocompra;
    private float precioventa;

    @ManyToOne
    @JoinColumn(name = "idUnidadMedida")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "idMarca", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idSucursal", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "idSubcategoria", nullable = false)
    private Subcategoria subcategoria;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Set<DetalleVenta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<DetalleVenta> ventas) {
		this.ventas = ventas;
	}

	public Set<DetalleCompra> getCompras() {
		return compras;
	}

	public void setCompras(Set<DetalleCompra> compras) {
		this.compras = compras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public float getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(float preciocompra) {
		this.preciocompra = preciocompra;
	}

	public float getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(float precioventa) {
		this.precioventa = precioventa;
	}

	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Producto(Set<DetalleVenta> ventas, Set<DetalleCompra> compras, String nombre, String descripcion,
			Integer stock, float preciocompra, float precioventa, UnidadMedida unidadMedida, Marca marca,
			Sucursal sucursal, Subcategoria subcategoria) {
		super();
		this.ventas = ventas;
		this.compras = compras;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
		this.unidadMedida = unidadMedida;
		this.marca = marca;
		this.sucursal = sucursal;
		this.subcategoria = subcategoria;
	}

	public Producto() {
		super();
	}
    
    
}
    
    


