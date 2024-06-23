package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Subcategoria;
import com.panaderia.system.repository.SubcategoriaRepository;
import com.panaderia.system.service.SubcategoriaService;


@Service
public class SubcategoriaServiceImpl implements SubcategoriaService {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Override
    public List<Subcategoria> buscarTodos() {
        return subcategoriaRepository.findAll();
    }

    @Override
    public void guardar(Subcategoria subcategoria) {
        subcategoriaRepository.save(subcategoria);
    }

    @Override
    public void modificar(Subcategoria subcategoria) {
        subcategoriaRepository.save(subcategoria);
    }

    @Override
    public Optional<Subcategoria> buscarId(Integer idCategoria) {
        return subcategoriaRepository.findById(idCategoria);
    }

    @Override
    public void eliminar(Integer idCategoria) {
        subcategoriaRepository.deleteById(idCategoria);
    }

}

