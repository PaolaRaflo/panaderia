package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Cliente;
import com.panaderia.system.repository.ClienteRepository;
import com.panaderia.system.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void modificar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarId(Integer idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public void eliminar(Integer idCliente) {
        clienteRepository.deleteById(idCliente);
    }

}

