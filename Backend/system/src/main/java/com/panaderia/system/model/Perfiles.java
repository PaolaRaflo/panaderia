package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  idperfil;
	private String perfil;

	public Integer getIdPerfil() {
		return idperfil;
	}

	public void setIdPerfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Perfiles(Integer idperfil, String perfil) {
		super();
		this.idperfil = idperfil;
		this.perfil = perfil;
	}
	

	public Perfiles(String perfil) {
		super();
		this.perfil = perfil;
	}

	public Perfiles() {
		super();
	}

    
   
    
}