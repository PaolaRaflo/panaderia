package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.NumeroSerie;
import com.panaderia.system.repository.NumeroSerieRepository;
import com.panaderia.system.service.NumeroSerieService;

@Service
public class NumeroSerieServiceImpl implements NumeroSerieService {

    @Autowired
    private NumeroSerieRepository numeroSerieRepository;

    @Override
    public List<NumeroSerie> buscarTodos() {
        return numeroSerieRepository.findAll();
    }

    @Override
    public Optional<NumeroSerie> buscarId(Integer id) {
        return numeroSerieRepository.findById(id);
    }

    @Override
    public NumeroSerie guardar(NumeroSerie numeroSerie) {
        return numeroSerieRepository.save(numeroSerie);
    }

    @Override
    public NumeroSerie modificar(NumeroSerie numeroSerie) {
        return numeroSerieRepository.save(numeroSerie);
    }

    @Override
    public void eliminar(Integer id) {
        numeroSerieRepository.deleteById(id);
    }
}
