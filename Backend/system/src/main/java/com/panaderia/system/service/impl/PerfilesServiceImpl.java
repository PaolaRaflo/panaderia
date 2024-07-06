package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panaderia.system.model.Perfiles;
import com.panaderia.system.repository.PerfilesRepository;
import com.panaderia.system.service.PerfilesService;

@Service
public class PerfilesServiceImpl implements PerfilesService {

	@Autowired
    private PerfilesRepository perfilesRepository;

    @Override
    public List<Perfiles> buscarTodos() {
        return perfilesRepository.findAll();
    }

    @Override
    public void guardar(Perfiles perfil) {
        perfilesRepository.save(perfil);
    }

    @Override
    public void modificar(Perfiles perfil) {
        perfilesRepository.save(perfil);
    }

  
    
    @Override
    public Optional<Perfiles> buscarId(Integer idperfil) {
        return perfilesRepository.findById(idperfil);
    }

    @Override
    public void eliminar(Integer idperfil) {
        perfilesRepository.deleteById(idperfil);
    }

}

