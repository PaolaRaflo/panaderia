package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Proveedor;

public interface ProveedorService {

    List<Proveedor> buscarTodos();
    void guardar(Proveedor proveedor);
    void modificar(Proveedor proveedor);
    Optional<Proveedor> buscarId(Integer idProveedor);
    void eliminar(Integer idProveedor);

}
