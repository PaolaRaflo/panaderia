package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Perfiles;

public interface PerfilesService {

    List<Perfiles> buscarTodos();
    void guardar(Perfiles perfil);
    void modificar(Perfiles perfil);
    Optional<Perfiles> buscarId(Integer idperfil);
    void eliminar(Integer idperfil);

}