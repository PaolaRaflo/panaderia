package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.ViewModulosPadre;

public interface ViewModulosPadreService {

    List<ViewModulosPadre> buscarTodos();
    Optional<ViewModulosPadre> buscarId(Integer idmodulo);
   

}