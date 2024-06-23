package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_comprobante")
public class TipoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idTipoComprobante;

    private String nombre;
    
    private String acronimo;

	

	public Integer getIdTipoComprobante() {
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public TipoComprobante(Integer idTipoComprobante, String nombre, String acronimo) {
		super();
		this.idTipoComprobante = idTipoComprobante;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}

	public TipoComprobante(String nombre, String acronimo) {
		super();
		this.nombre = nombre;
		this.acronimo = acronimo;
	}

	public TipoComprobante(Integer idTipoComprobante) {
		super();
		this.idTipoComprobante = idTipoComprobante;
	}

	public TipoComprobante() {
		super();
	}

    
    
}
