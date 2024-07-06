package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panaderia.system.model.Accesos;
import com.panaderia.system.repository.AccesosRepository;
import com.panaderia.system.service.AccesosService;

@Service
public class AccesosServiceImpl implements AccesosService {

	@Autowired
    private AccesosRepository accesosRepository;

    @Override
    public List<Accesos> buscarTodos() {
        return accesosRepository.findAll();
    }

    @Override
    public void guardar(Accesos acceso) {
        accesosRepository.save(acceso);
    }

    @Override
    public void modificar(Accesos acceso) {
        accesosRepository.save(acceso);
    }

  
    
    @Override
    public Optional<Accesos> buscarId(Integer idacceso) {
        return accesosRepository.findById(idacceso);
    }

    @Override
    public void eliminar(Integer idacceso) {
        accesosRepository.deleteById(idacceso);
    }
    @Override
    public void deleteAccesosByIdperfil(Integer idperfil) {
        accesosRepository.deleteByIdperfil(idperfil);
    }

}

