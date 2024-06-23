package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.TipoComprobante;

public interface TipoComprobanteService {
    List<TipoComprobante> buscarTodos();
    Optional<TipoComprobante> buscarId(Integer id);
    TipoComprobante guardar(TipoComprobante tipoComprobante);
    TipoComprobante modificar(TipoComprobante tipoComprobante);
    void eliminar(Integer id);
}
