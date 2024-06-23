package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidad_medida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidadMedida;

    private String nombre;
    private String descripcion;
    private String abreviatura;
	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
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
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public UnidadMedida(Integer idUnidadMedida, String nombre, String descripcion, String abreviatura) {
		super();
		this.idUnidadMedida = idUnidadMedida;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.abreviatura = abreviatura;
	}
	public UnidadMedida(String nombre, String descripcion, String abreviatura) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.abreviatura = abreviatura;
	}
	public UnidadMedida() {
		super();
	}

    

   
}

