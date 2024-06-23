package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Venta;
import com.panaderia.system.repository.VentaRepository;
import com.panaderia.system.service.VentaService;


@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> buscarTodos() {
        return ventaRepository.findAll();
    }

    @Override
    public void guardar(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public void modificar(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public Optional<Venta> buscarId(Integer idVenta) {
        return ventaRepository.findById(idVenta);
    }

    @Override
    public void eliminar(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }

}

