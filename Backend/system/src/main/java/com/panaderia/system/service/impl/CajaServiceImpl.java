package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Caja;
import com.panaderia.system.repository.CajaRepository;
import com.panaderia.system.service.CajaService;


@Service
public class CajaServiceImpl implements CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    @Override
    public List<Caja> buscarTodos() {
        return cajaRepository.findAll();
    }

    @Override
    public void guardar(Caja caja) {
        cajaRepository.save(caja);
    }

    @Override
    public void modificar(Caja caja) {
        cajaRepository.save(caja);
    }

    @Override
    public Optional<Caja> buscarId(Integer idCaja) {
        return cajaRepository.findById(idCaja);
    }

    @Override
    public void eliminar(Integer idCaja) {
        cajaRepository.deleteById(idCaja);
    }

}

