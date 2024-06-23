package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.DetalleVenta;

public interface DetalleVentaService {
    List<DetalleVenta> buscarTodos();
    Optional<DetalleVenta> buscarId(Integer idDetalleVenta);
    DetalleVenta guardar(DetalleVenta detalleVenta);
    void eliminar(Integer idDetalleVenta);
}

