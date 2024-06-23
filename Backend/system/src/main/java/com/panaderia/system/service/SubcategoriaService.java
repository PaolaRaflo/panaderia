package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Subcategoria;

public interface SubcategoriaService {

    List<Subcategoria> buscarTodos();
    void guardar(Subcategoria subcategoria);
    void modificar(Subcategoria subcategoria);
    Optional<Subcategoria> buscarId(Integer idCategoria);
    void eliminar(Integer idCategoria);

}