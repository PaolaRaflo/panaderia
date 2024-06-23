package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "detalle_compra")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCompra;

    @ManyToOne
    @JoinColumn(name = "idCompra")
    @JsonBackReference
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    private Integer cantidad;
    private Double total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleCompra that = (DetalleCompra) o;
        return Objects.equals(idDetalleCompra, that.idDetalleCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalleCompra);
    }

	public Integer getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(Integer idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public DetalleCompra(Integer idDetalleCompra, Compra compra, Producto producto, Integer cantidad, Double total) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public DetalleCompra(Compra compra, Producto producto, Integer cantidad, Double total) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public DetalleCompra() {
		super();
	}
    
    
}


