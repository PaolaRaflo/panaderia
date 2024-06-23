package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoCliente")
public class TipoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoCliente;

    private String nombre;

	public Integer getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(Integer idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoCliente(Integer idTipoCliente, String nombre) {
		super();
		this.idTipoCliente = idTipoCliente;
		this.nombre = nombre;
	}

	public TipoCliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	public TipoCliente() {
		super();
	}

    

    
}
