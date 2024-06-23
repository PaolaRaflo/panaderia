package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.DetalleCompra;

public interface DetalleCompraService {

    List<DetalleCompra> buscarTodos();
    void guardar(DetalleCompra detalleCompra);
    void modificar(DetalleCompra detalleCompra);
    Optional<DetalleCompra> buscarId(Integer idDetalleCompra);
    void eliminar(Integer idDetalleCompra);

}
