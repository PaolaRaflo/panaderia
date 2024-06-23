package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Compra;

public interface CompraService {

    List<Compra> buscarTodos();
    void guardar(Compra compra);
    void modificar(Compra compra);
    Optional<Compra> buscarId(Integer idCompra);
    void eliminar(Integer idCompra);

}
