package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_modulos_padre")
public class ViewModulosPadre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idmodulo;
	private String modulo;
	private String url;
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

	

	public ViewModulosPadre(Integer idmodulo, String modulo, String url, Integer orden) {
		super();
		this.idmodulo = idmodulo;
		this.modulo = modulo;
		this.url = url;
		this.orden = orden;
	}
	

	public ViewModulosPadre(String modulo) {
		super();
		this.modulo = modulo;
	}

	public ViewModulosPadre() {
		super();
	}

    
   
    
}