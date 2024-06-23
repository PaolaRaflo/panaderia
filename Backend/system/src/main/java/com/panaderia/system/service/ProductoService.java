package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Producto;

public interface ProductoService {

    List<Producto> buscarTodos();
    void guardar(Producto producto);
    void modificar(Producto producto);
    Optional<Producto> buscarId(Integer idProducto);
    void eliminar(Integer idProducto);

}
