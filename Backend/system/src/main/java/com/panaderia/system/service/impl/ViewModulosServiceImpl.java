package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.ViewModulos;
import com.panaderia.system.repository.ViewModulosRepository;
import com.panaderia.system.service.ViewModulosService;

@Service
public class ViewModulosServiceImpl implements ViewModulosService {

	@Autowired
    private ViewModulosRepository modulosRepository;

    @Override
    public List<ViewModulos> buscarTodos() {
        return modulosRepository.findAll();
    }

    
    @Override
    public Optional<ViewModulos> buscarId(Integer idmodulo) {
        return modulosRepository.findById(idmodulo);
    }

 

}

