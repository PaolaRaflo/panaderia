package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSucursal;

    private String nombre;
    private String estado;
    
    
	public Integer getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Sucursal(Integer idSucursal, String nombre, String estado) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
		this.estado = estado;
	}
	public Sucursal(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
	}
	public Sucursal() {
		super();
	}

	
    

}
