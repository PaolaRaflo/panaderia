package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Subcategoria;
import com.panaderia.system.service.SubcategoriaService;

@RestController
@RequestMapping("/api/v1/subcategorias")
@CrossOrigin(origins = "*")
public class SubcategoriaController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping
    public List<Subcategoria> buscarTodos() {
        return subcategoriaService.buscarTodos();
    }

    @PostMapping
    public Subcategoria guardar(@RequestBody Subcategoria subcategoria) {
        subcategoriaService.guardar(subcategoria);
        return subcategoria;
    }

    @PutMapping
    public Subcategoria modificar(@RequestBody Subcategoria subcategoria) {
        subcategoriaService.modificar(subcategoria);
        return subcategoria;
    }

    @GetMapping("/{idCategoria}")
    public Optional<Subcategoria> buscarId(@PathVariable("idCategoria") Integer idCategoria) {
        return subcategoriaService.buscarId(idCategoria);
    }

    @DeleteMapping("/{idCategoria}")
    public String eliminar(@PathVariable("idCategoria") Integer idCategoria) {
        subcategoriaService.eliminar(idCategoria);
        return "Subcategoria eliminada";
    }

}

