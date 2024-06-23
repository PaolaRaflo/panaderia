package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.Compra;
import com.panaderia.system.repository.CompraRepository;
import com.panaderia.system.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> buscarTodos() {
        return compraRepository.findAll();
    }

    @Override
    public void guardar(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public void modificar(Compra compra) {
        compraRepository.save(compra);
    }

    @Override
    public Optional<Compra> buscarId(Integer idCompra) {
        return compraRepository.findById(idCompra);
    }

    @Override
    public void eliminar(Integer idCompra) {
        compraRepository.deleteById(idCompra);
    }

}
