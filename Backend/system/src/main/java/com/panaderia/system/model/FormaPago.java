package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forma_pago")
public class FormaPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idFormaPago;

    private String nombre;

	public Integer getIdFormaPago() {
		return idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public FormaPago(Integer idFormaPago, String nombre) {
		super();
		this.idFormaPago = idFormaPago;
		this.nombre = nombre;
	}

	public FormaPago(String nombre) {
		super();
		this.nombre = nombre;
	}

	public FormaPago() {
		super();
	}

    
    
}