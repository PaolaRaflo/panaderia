package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_modulos")
public class ViewModulos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idmodulo;
	private String modulo;
	private String url;
	private Integer orden;
	private String modulo_padre;
	private Integer idpadre;

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

	public String getModuloPadre() {
		return modulo_padre;
	}

	public void setModuloPadre(String modulo_padre) {
		this.modulo_padre = modulo_padre;
	}

	public Integer getIdPadre() {
		return idpadre;
	}

	public void setIdPadre(Integer idpadre) {
		this.idpadre = idpadre;
	}
	

	public ViewModulos(Integer idmodulo, String modulo, String url, Integer orden, String modulo_padre, Integer idpadre) {
		super();
		this.idmodulo = idmodulo;
		this.modulo = modulo;
		this.url = url;
		this.orden = orden;
		this.modulo_padre = modulo_padre;
		this.idpadre = idpadre;
	}
	

	public ViewModulos(String modulo) {
		super();
		this.modulo = modulo;
	}

	public ViewModulos() {
		super();
	}

    
   
    
}