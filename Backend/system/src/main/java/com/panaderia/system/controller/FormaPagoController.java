package com.panaderia.system.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.FormaPago;
import com.panaderia.system.service.FormaPagoService;


@RestController
@RequestMapping("/api/v1/formas_pago")
@CrossOrigin(origins = "*")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    @GetMapping
    public List<FormaPago> buscarTodos() {
        return formaPagoService.buscarTodos();
    }

    @PostMapping
    public FormaPago guardar(@RequestBody FormaPago formaPago) {
        formaPagoService.guardar(formaPago);
        return formaPago;
    }

    @PutMapping
    public FormaPago modificar(@RequestBody FormaPago formaPago) {
        formaPagoService.modificar(formaPago);
        return formaPago;
    }

    @GetMapping("/{idFormaPago}")
    public Optional<FormaPago> buscarId(@PathVariable("idFormaPago") Integer idFormaPago) {
        return formaPagoService.buscarId(idFormaPago);
    }

    @DeleteMapping("/{idFormaPago}")
    public String eliminar(@PathVariable("idFormaPago") Integer idFormaPago) {
        formaPagoService.eliminar(idFormaPago);
        return "Forma de pago eliminada";
    }

}

