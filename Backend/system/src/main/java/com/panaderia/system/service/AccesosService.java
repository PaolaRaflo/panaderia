package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;

import com.panaderia.system.model.Accesos;

public interface AccesosService {

    List<Accesos> buscarTodos();
    void guardar(Accesos acceso);
    void modificar(Accesos acceso);
    Optional<Accesos> buscarId(Integer idacceso);
    void eliminar(Integer idacceso);
    void deleteAccesosByIdperfil(Integer idperfil);

}