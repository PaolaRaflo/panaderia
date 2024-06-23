package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Venta;

public interface VentaService {

    List<Venta> buscarTodos();
    void guardar(Venta venta);
    void modificar(Venta venta);
    Optional<Venta> buscarId(Integer idVenta);
    void eliminar(Integer idVenta);

}
