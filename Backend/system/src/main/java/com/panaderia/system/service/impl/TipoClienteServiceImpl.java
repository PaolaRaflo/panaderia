package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.TipoCliente;
import com.panaderia.system.repository.TipoClienteRepository;
import com.panaderia.system.service.TipoClienteService;


@Service
public class TipoClienteServiceImpl implements TipoClienteService {

	@Autowired
    private TipoClienteRepository tipoClienteRepository;
    @Override
    public List<TipoCliente> buscarTodos() {
        return tipoClienteRepository.findAll();
    }

    @Override
    public void guardar(TipoCliente tipoCliente) {
        tipoClienteRepository.save(tipoCliente);
       
    }

    @Override
    public void modificar(TipoCliente tipoCliente) {
        
        tipoClienteRepository.save(tipoCliente);
    }

    @Override
    public Optional<TipoCliente> buscarId(Integer idTipoCliente) {
        return tipoClienteRepository.findById(idTipoCliente);
    }

    @Override
    public void eliminar(Integer idTipoCliente) {
        tipoClienteRepository.deleteById(idTipoCliente);
    }

}
