package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Marca;
import com.panaderia.system.repository.MarcaRepository;
import com.panaderia.system.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    @Override
    public void guardar(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public void modificar(Marca marca) {
        marcaRepository.save(marca);
    }

    @Override
    public Optional<Marca> buscarId(Integer idMarca) {
        return marcaRepository.findById(idMarca);
    }

    @Override
    public void eliminar(Integer idMarca) {
        marcaRepository.deleteById(idMarca);
    }

}

