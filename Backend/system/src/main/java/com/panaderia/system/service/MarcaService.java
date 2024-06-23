package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Marca;

public interface MarcaService {

    List<Marca> buscarTodos();
    void guardar(Marca marca);
    void modificar(Marca marca);
    Optional<Marca> buscarId(Integer idMarca);
    void eliminar(Integer idMarca);

}