package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.DetalleVenta;
import com.panaderia.system.repository.DetalleVentaRepository;
import com.panaderia.system.service.DetalleVentaService;


@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> buscarTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> buscarId(Integer idDetalleVenta) {
        return detalleVentaRepository.findById(idDetalleVenta);
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void eliminar(Integer idDetalleVenta) {
        detalleVentaRepository.deleteById(idDetalleVenta);
    }
}
