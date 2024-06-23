package com.panaderia.system.service;

import java.util.List;
import java.util.Optional;
import com.panaderia.system.model.Cliente;

public interface ClienteService {

    List<Cliente> buscarTodos();
    void guardar(Cliente cliente);
    void modificar(Cliente cliente);
    Optional<Cliente> buscarId(Integer idCliente);
    void eliminar(Integer idCliente);

}

