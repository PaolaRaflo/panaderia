package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Modulos;

public interface ModulosService {

    List<Modulos> buscarTodos();
    void guardar(Modulos modulo);
    void modificar(Modulos modulo);
    Optional<Modulos> buscarId(Integer idmodulo);
    void eliminar(Integer idmodulo);

}