package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.ViewAccesos;
import com.panaderia.system.repository.ViewAccesosRepository;
import com.panaderia.system.service.ViewAccesosService;

@Service
public class ViewAccesosServiceImpl implements ViewAccesosService {

	@Autowired
    private ViewAccesosRepository viewAccesos;

    @Override
    public List<ViewAccesos> buscarTodos() {
        return viewAccesos.findAll();
    }

    
    @Override
    public Optional<ViewAccesos> buscarId(Integer idacceso) {
        return viewAccesos.findById(idacceso);
    }

 

}

