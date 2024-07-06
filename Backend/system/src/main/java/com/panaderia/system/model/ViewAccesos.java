package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_accesos")
public class ViewAccesos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idacceso;
	private Integer  idmodulo;
	private String modulo;
	private String url;
	private Integer orden;
	private Integer idpadre;
	private String modulo_padre;
	private Integer idperfil;
	private String perfil;
	private Integer iduser;

	public Integer getIdacceso() {
		return idacceso;
	}

	public void setIdacceso(Integer idacceso) {
		this.idacceso = idacceso;
	}

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

	public Integer getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public ViewAccesos(Integer idacceso, Integer idmodulo, String modulo, String url, Integer orden, String modulo_padre, Integer idpadre, Integer idperfil, String perfil, Integer iduser) {
		super();
		this.idacceso = idacceso;
		this.idmodulo = idmodulo;
		this.modulo = modulo;
		this.url = url;
		this.orden = orden;
		this.modulo_padre = modulo_padre;
		this.idpadre = idpadre;
		this.idperfil = idperfil;
		this.idperfil = idperfil;
		this.perfil = perfil;
		this.iduser = iduser;
	}
	

	public ViewAccesos(String modulo) {
		super();
		this.modulo = modulo;
	}

	public ViewAccesos() {
		super();
	}

    
   
    
}