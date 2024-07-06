package com.panaderia.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accesos")
public class Accesos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idacceso;
    private Integer idperfil;
    private Integer idmodulo;

	public Integer getIdAcceso() {
		return idacceso;
	}

	public void setIdAcceso(Integer idacceso) {
		this.idacceso = idacceso;
	}

	public Integer getIdPerfil() {
		return idperfil;
	}

	public void setIdPerfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public void setIdModulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	public Integer getIdModulo() {
		return idmodulo;
	}

	public Accesos(Integer idacceso, Integer idperfil, Integer idmodulo) {
		super();
		this.idacceso = idacceso;
		this.idperfil = idperfil;
		this.idmodulo = idmodulo;
	}
	

	public Accesos(Integer idperfil) {
		super();
		this.idperfil = idperfil;
	}

	public Accesos() {
		super();
	}

    
   
    
}