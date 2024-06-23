package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.UnidadMedida;
import com.panaderia.system.service.UnidadMedidaService;

@RestController
@RequestMapping("/api/v1/unidades_medida")
@CrossOrigin(origins = "*")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping
    public List<UnidadMedida> buscarTodos() {
        return unidadMedidaService.buscarTodos();
    }

    @PostMapping
    public UnidadMedida guardar(@RequestBody UnidadMedida unidadMedida) {
        unidadMedidaService.guardar(unidadMedida);
        return unidadMedida;
    }

    @PutMapping("/{idUnidadMedida}")
    public UnidadMedida modificar(@RequestBody UnidadMedida unidadMedida) {
        unidadMedidaService.modificar(unidadMedida);
        return unidadMedida;
    }

    @GetMapping("/{idUnidadMedida}")
    public Optional<UnidadMedida> buscarId(@PathVariable("idUnidadMedida") Integer idUnidadMedida) {
        return unidadMedidaService.buscarId(idUnidadMedida);
    }

    @DeleteMapping("/{idUnidadMedida}")
    public String eliminar(@PathVariable("idUnidadMedida") Integer idUnidadMedida) {
        unidadMedidaService.eliminar(idUnidadMedida);
        return "Unidad de medida eliminada";
    }

}

