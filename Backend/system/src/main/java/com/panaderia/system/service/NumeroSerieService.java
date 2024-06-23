package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.NumeroSerie;

public interface NumeroSerieService {
    List<NumeroSerie> buscarTodos();
    Optional<NumeroSerie> buscarId(Integer id);
    NumeroSerie guardar(NumeroSerie numeroSerie);
    NumeroSerie modificar(NumeroSerie numeroSerie);
    void eliminar(Integer id);
}
