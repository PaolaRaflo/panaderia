package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Proveedor;
import com.panaderia.system.repository.ProveedorRepository;
import com.panaderia.system.service.ProveedorService;


@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> buscarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public void guardar(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public void modificar(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<Proveedor> buscarId(Integer idProveedor) {
        return proveedorRepository.findById(idProveedor);
    }

    @Override
    public void eliminar(Integer idProveedor) {
        proveedorRepository.deleteById(idProveedor);
    }

}

