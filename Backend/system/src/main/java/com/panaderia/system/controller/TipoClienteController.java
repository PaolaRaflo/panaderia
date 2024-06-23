package com.panaderia.system.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.TipoCliente;
import com.panaderia.system.service.TipoClienteService;

@RestController
@RequestMapping("/api/v1/tipoclientes")
@CrossOrigin(origins = "*")
public class TipoClienteController {

    @Autowired
    private TipoClienteService tipoClienteService;

    @GetMapping
    public List<TipoCliente> buscarTodos() {
        return tipoClienteService.buscarTodos();
    }



    @PostMapping
    public TipoCliente guardar(@RequestBody TipoCliente tipoCliente) {
        tipoClienteService.guardar(tipoCliente);
        return tipoCliente;
    }

    @PutMapping
    public TipoCliente modificar(@RequestBody TipoCliente tipoCliente) {
        tipoClienteService.modificar(tipoCliente);
        return tipoCliente;
    }

    @GetMapping("/{idTipoCliente}")
    public Optional<TipoCliente> buscarId(@PathVariable("idTipoCliente") Integer idTipoCliente) {
        return tipoClienteService.buscarId(idTipoCliente);
    }

    @DeleteMapping("/{idTipoCliente}")
    public String eliminar(@PathVariable("idTipoCliente") Integer idTipoCliente) {
        tipoClienteService.eliminar(idTipoCliente);
        return "idTipoCliente eliminada";
    }

    

}

