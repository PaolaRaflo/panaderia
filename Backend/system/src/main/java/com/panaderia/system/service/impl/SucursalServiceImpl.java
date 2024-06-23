package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Sucursal;
import com.panaderia.system.repository.SucursalRepository;
import com.panaderia.system.service.SucursalService;


@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> buscarTodos() {
        return sucursalRepository.findAll();
    }

    @Override
    public void guardar(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public void modificar(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public Optional<Sucursal> buscarId(Integer idSucursal) {
        return sucursalRepository.findById(idSucursal);
    }

    @Override
    public void eliminar(Integer idSucursal) {
        sucursalRepository.deleteById(idSucursal);
    }

}


