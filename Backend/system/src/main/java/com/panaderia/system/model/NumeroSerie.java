package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "numero_serie")
public class NumeroSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idNumeroSerie;
    private Integer numero;
    
	public Integer getIdNumeroSerie() {
		return idNumeroSerie;
	}
	public void setIdNumeroSerie(Integer idNumeroSerie) {
		this.idNumeroSerie = idNumeroSerie;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public NumeroSerie(Integer idNumeroSerie, Integer numero) {
		super();
		this.idNumeroSerie = idNumeroSerie;
		this.numero = numero;
	}
	
	public NumeroSerie() {
		super();
	}
    
    
  
}
   