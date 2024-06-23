package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Caja;

public interface CajaService {
    List<Caja> buscarTodos();
	void guardar(Caja caja);
	void modificar(Caja caja);
	Optional<Caja> buscarId(Integer idCaja);
	void eliminar(Integer idCaja); 

}