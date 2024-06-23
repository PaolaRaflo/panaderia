package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Producto;
import com.panaderia.system.repository.ProductoRepository;
import com.panaderia.system.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void modificar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarId(Integer idProducto) {
        return productoRepository.findById(idProducto);
    }

    @Override
    public void eliminar(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }

}

