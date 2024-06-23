package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.TipoCliente;

public interface TipoClienteService {

    List<TipoCliente> buscarTodos();
	void guardar(TipoCliente tipoCliente);
	void modificar(TipoCliente tipoCliente);
	Optional<TipoCliente> buscarId(Integer idTipoCliente);
	void eliminar(Integer idTipoCliente); 

}
