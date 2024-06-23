package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.FormaPago;

public interface FormaPagoService {

    List<FormaPago> buscarTodos();
    void guardar(FormaPago formaPago);
    void modificar(FormaPago formaPago);
    Optional<FormaPago> buscarId(Integer idFormaPago);
    void eliminar(Integer idFormaPago);

}
