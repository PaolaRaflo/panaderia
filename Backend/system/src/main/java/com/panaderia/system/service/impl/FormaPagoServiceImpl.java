package com.panaderia.system.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.panaderia.system.model.FormaPago;
import com.panaderia.system.repository.FormaPagoRepository;
import com.panaderia.system.service.FormaPagoService;


@Service
public class FormaPagoServiceImpl implements FormaPagoService {

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    @Override
    public List<FormaPago> buscarTodos() {
        return formaPagoRepository.findAll();
    }

    @Override
    public void guardar(FormaPago formaPago) {
        formaPagoRepository.save(formaPago);
    }

    @Override
    public void modificar(FormaPago formaPago) {
        formaPagoRepository.save(formaPago);
    }

    @Override
    public Optional<FormaPago> buscarId(Integer idFormaPago) {
        return formaPagoRepository.findById(idFormaPago);
    }

    @Override
    public void eliminar(Integer idFormaPago) {
        formaPagoRepository.deleteById(idFormaPago);
    }

}
