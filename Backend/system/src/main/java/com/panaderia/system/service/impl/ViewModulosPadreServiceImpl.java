package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.ViewModulosPadre;
import com.panaderia.system.repository.ViewModulosPadreRepository;
import com.panaderia.system.service.ViewModulosPadreService;

@Service
public class ViewModulosPadreServiceImpl implements ViewModulosPadreService {

	@Autowired
    private ViewModulosPadreRepository modulosRepository;

    @Override
    public List<ViewModulosPadre> buscarTodos() {
        return modulosRepository.findAll();
    }

    
    @Override
    public Optional<ViewModulosPadre> buscarId(Integer idmodulo) {
        return modulosRepository.findById(idmodulo);
    }

 

}

