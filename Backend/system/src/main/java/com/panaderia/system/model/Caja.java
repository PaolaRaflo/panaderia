package com.panaderia.system.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaja;

    private String nombre;
    private String estado;
    private Double montoInicial;
    private Double montoFinal;
    private Date fecha;
	public Integer getIdCaja() {
		return idCaja;
	}
	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
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
	public Double getMontoInicial() {
		return montoInicial;
	}
	public void setMontoInicial(Double montoInicial) {
		this.montoInicial = montoInicial;
	}
	public Double getMontoFinal() {
		return montoFinal;
	}
	public void setMontoFinal(Double montoFinal) {
		this.montoFinal = montoFinal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Caja(Integer idCaja, String nombre, String estado, Double montoInicial, Double montoFinal, Date fecha) {
		super();
		this.idCaja = idCaja;
		this.nombre = nombre;
		this.estado = estado;
		this.montoInicial = montoInicial;
		this.montoFinal = montoFinal;
		this.fecha = fecha;
	}
	public Caja(String nombre, String estado, Double montoInicial, Double montoFinal, Date fecha) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.montoInicial = montoInicial;
		this.montoFinal = montoFinal;
		this.fecha = fecha;
	}
	public Caja() {
		super();
	}

    
   

}
