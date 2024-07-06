package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.ViewModulos;

public interface ViewModulosService {

    List<ViewModulos> buscarTodos();
    Optional<ViewModulos> buscarId(Integer idmodulo);
   

}