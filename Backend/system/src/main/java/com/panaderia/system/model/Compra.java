package com.panaderia.system.model;

//import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "idProveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "idFormaPago")
    private FormaPago formaPago;

    private Double total;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<DetalleCompra> detalleCompras = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idCaja")
    private Caja caja;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(idCompra, compra.idCompra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra);
    }

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Set<DetalleCompra> getDetalleCompras() {
		return detalleCompras;
	}

	public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
		this.detalleCompras = detalleCompras;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Compra(Integer idCompra, String fecha, Proveedor proveedor, FormaPago formaPago, Double total,
			Set<DetalleCompra> detalleCompras, User user, Caja caja) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.formaPago = formaPago;
		this.total = total;
		this.detalleCompras = detalleCompras;
		this.user = user;
		this.caja = caja;
	}

	public Compra(String fecha, Proveedor proveedor, FormaPago formaPago, Double total,
			Set<DetalleCompra> detalleCompras, User user, Caja caja) {
		super();
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.formaPago = formaPago;
		this.total = total;
		this.detalleCompras = detalleCompras;
		this.user = user;
		this.caja = caja;
	}

	public Compra() {
		super();
	}
    
    
    
}

