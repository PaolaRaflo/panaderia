package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Sucursal;

public interface SucursalService {

    List<Sucursal> buscarTodos();
    void guardar(Sucursal sucursal);
    void modificar(Sucursal sucursal);
    Optional<Sucursal> buscarId(Integer idSucursal);
    void eliminar(Integer idSucursal);

}

