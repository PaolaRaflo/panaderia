package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Modulos;
import com.panaderia.system.repository.ModulosRepository;
import com.panaderia.system.service.ModulosService;

@Service
public class ModulosServiceImpl implements ModulosService {

	@Autowired
    private ModulosRepository modulosRepository;

    @Override
    public List<Modulos> buscarTodos() {
        return modulosRepository.findAll();
    }

    @Override
    public void guardar(Modulos modulo) {
        modulosRepository.save(modulo);
    }

    @Override
    public void modificar(Modulos modulo) {
        modulosRepository.save(modulo);
    }

    @Override
    public Optional<Modulos> buscarId(Integer idmodulo) {
        return modulosRepository.findById(idmodulo);
    }

    @Override
    public void eliminar(Integer idmodulo) {
        modulosRepository.deleteById(idmodulo);
    }

}

