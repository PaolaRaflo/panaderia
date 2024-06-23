package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panaderia.system.model.UnidadMedida;
import com.panaderia.system.repository.UnidadMedidaRepository;
import com.panaderia.system.service.UnidadMedidaService;


@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @Override
    public List<UnidadMedida> buscarTodos() {
        return unidadMedidaRepository.findAll();
    }

    @Override
    public void guardar(UnidadMedida unidadMedida) {
        unidadMedidaRepository.save(unidadMedida);
    }

    @Override
    public void modificar(UnidadMedida unidadMedida) {
        unidadMedidaRepository.save(unidadMedida);
    }

    @Override
    public Optional<UnidadMedida> buscarId(Integer idUnidadMedida) {
        return unidadMedidaRepository.findById(idUnidadMedida);
    }

    @Override
    public void eliminar(Integer idUnidadMedida) {
        unidadMedidaRepository.deleteById(idUnidadMedida);
    }

}



