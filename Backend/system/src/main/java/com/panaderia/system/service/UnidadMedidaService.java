package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.UnidadMedida;

public interface UnidadMedidaService {

    List<UnidadMedida> buscarTodos();
    void guardar(UnidadMedida unidadMedida);
    void modificar(UnidadMedida unidadMedida);
    Optional<UnidadMedida> buscarId(Integer idUnidadMedida);
    void eliminar(Integer idUnidadMedida);

}

