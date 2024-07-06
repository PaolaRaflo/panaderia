package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.ViewAccesos;

public interface ViewAccesosService {

    List<ViewAccesos> buscarTodos();
    Optional<ViewAccesos> buscarId(Integer idacceso);
   

}