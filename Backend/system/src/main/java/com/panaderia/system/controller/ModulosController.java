package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panaderia.system.model.Modulos;
import com.panaderia.system.service.ModulosService;

@RestController
@RequestMapping("/api/v1/modulos")
@CrossOrigin(origins = "*")
public class ModulosController {

    @Autowired
    private ModulosService modulosService;

    @GetMapping
    public List<Modulos> buscarTodos() {
        return modulosService.buscarTodos();
    }

    @PostMapping
    public Modulos guardar(@RequestBody Modulos modulo) {
        modulosService.guardar(modulo);
        return modulo;
    }

    @PutMapping("/{id}")    
    public Modulos modificar(@PathVariable Integer id, @RequestBody Modulos modulo) {
        modulo.setIdModulo(id); 
        modulosService.modificar(modulo);
        return modulo;
    }

    @GetMapping("/{idmodulo}")
    public Optional<Modulos> buscarId(@PathVariable("idmodulo") Integer idmodulo) {
        return modulosService.buscarId(idmodulo);
    }

    @DeleteMapping("/{idmodulo}")
    public String eliminar(@PathVariable("idmodulo") Integer idmodulo) {
        modulosService.eliminar(idmodulo);
        return "Modulo eliminado";
    }

}
