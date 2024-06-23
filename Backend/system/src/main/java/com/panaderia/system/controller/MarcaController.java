package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Marca;
import com.panaderia.system.service.MarcaService;

@RestController
@RequestMapping("/api/v1/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> buscarTodos() {
        return marcaService.buscarTodos();
    }

    @PostMapping
    public Marca guardar(@RequestBody Marca marca) {
        marcaService.guardar(marca);
        return marca;
    }

    @PutMapping
    public Marca modificar(@RequestBody Marca marca) {
        marcaService.modificar(marca);
        return marca;
    }

    @GetMapping("/{idMarca}")
    public Optional<Marca> buscarId(@PathVariable("idMarca") Integer idMarca) {
        return marcaService.buscarId(idMarca);
    }

    @DeleteMapping("/{idMarca}")
    public String eliminar(@PathVariable("idMarca") Integer idMarca) {
        marcaService.eliminar(idMarca);
        return "Marca eliminada";
    }

}
