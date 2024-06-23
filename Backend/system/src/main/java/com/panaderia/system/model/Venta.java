package com.panaderia.system.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idVenta;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idTipoComprobante")
    private TipoComprobante tipoComprobante;

    @ManyToOne
    @JoinColumn(name = "idFormaPago")
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;
    
    @ManyToOne
    @JoinColumn(name = "idNumeroSerie")
    private NumeroSerie numeroserie;

    @OneToMany(mappedBy = "venta")
    private Set<DetalleVenta> detalleVentas = new HashSet<>();

    private Double total;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoComprobante getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public NumeroSerie getNumeroserie() {
		return numeroserie;
	}

	public void setNumeroserie(NumeroSerie numeroserie) {
		this.numeroserie = numeroserie;
	}

	public Set<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Venta(Integer idVenta, Date fecha, com.panaderia.system.model.Cliente cliente,
			com.panaderia.system.model.TipoComprobante tipoComprobante, com.panaderia.system.model.FormaPago formaPago,
			com.panaderia.system.model.Caja caja, com.panaderia.system.model.NumeroSerie numeroserie,
			Set<com.panaderia.system.model.DetalleVenta> detalleVentas, Double total,
			com.panaderia.system.model.User user) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.cliente = cliente;
		this.tipoComprobante = tipoComprobante;
		this.formaPago = formaPago;
		this.caja = caja;
		this.numeroserie = numeroserie;
		this.detalleVentas = detalleVentas;
		this.total = total;
		this.user = user;
	}

	public Venta(Date fecha, com.panaderia.system.model.Cliente cliente,
			com.panaderia.system.model.TipoComprobante tipoComprobante, com.panaderia.system.model.FormaPago formaPago,
			com.panaderia.system.model.Caja caja, com.panaderia.system.model.NumeroSerie numeroserie,
			Set<com.panaderia.system.model.DetalleVenta> detalleVentas, Double total,
			com.panaderia.system.model.User user) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.tipoComprobante = tipoComprobante;
		this.formaPago = formaPago;
		this.caja = caja;
		this.numeroserie = numeroserie;
		this.detalleVentas = detalleVentas;
		this.total = total;
		this.user = user;
	}

	public Venta() {
		super();
	}

	
    
}

