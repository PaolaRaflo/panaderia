package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "modulos")
public class Modulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idmodulo;
    private String modulo;
	private String url;
	private Integer idpadre;
	private Integer orden;

	public Integer getIdModulo() {
		return idmodulo;
	}

	public void setIdModulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getIdPadre() {
		return idpadre;
	}

	public void setIdPadre(Integer idpadre) {
		this.idpadre = idpadre;
	}

	public Modulos(Integer idmodulo, String modulo, String url, Integer idpadre, Integer orden) {
		super();
		this.idmodulo = idmodulo;
		this.modulo = modulo;
		this.url = url;
		this.idpadre = idpadre;
		this.orden = orden;
	}
	

	public Modulos(String modulo) {
		super();
		this.modulo = modulo;
	}

	public Modulos() {
		super();
	}

    
   
    
}