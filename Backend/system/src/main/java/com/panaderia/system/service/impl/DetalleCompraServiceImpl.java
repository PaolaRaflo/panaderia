package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.DetalleCompra;
import com.panaderia.system.repository.DetalleCompraRepository;
import com.panaderia.system.service.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

	@Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> buscarTodos() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public void guardar(DetalleCompra detalleCompra) {
        detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public void modificar(DetalleCompra detalleCompra) {
        detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public Optional<DetalleCompra> buscarId(Integer idDetalleCompra) {
        return detalleCompraRepository.findById(idDetalleCompra);
    }

    @Override
    public void eliminar(Integer idDetalleCompra) {
        detalleCompraRepository.deleteById(idDetalleCompra);
    }

}
