package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.TipoComprobante;
import com.panaderia.system.repository.TipoComprobanteRepository;
import com.panaderia.system.service.TipoComprobanteService;

@Service
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Override
    public List<TipoComprobante> buscarTodos() {
        return tipoComprobanteRepository.findAll();
    }

    @Override
    public Optional<TipoComprobante> buscarId(Integer id) {
        return tipoComprobanteRepository.findById(id);
    }

    @Override
    public TipoComprobante guardar(TipoComprobante tipoComprobante) {
        return tipoComprobanteRepository.save(tipoComprobante);
    }

    @Override
    public TipoComprobante modificar(TipoComprobante tipoComprobante) {
        return tipoComprobanteRepository.save(tipoComprobante);
    }

    @Override
    public void eliminar(Integer id) {
        tipoComprobanteRepository.deleteById(id);
    }
}

