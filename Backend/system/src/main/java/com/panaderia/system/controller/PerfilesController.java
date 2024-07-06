package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Perfiles;
import com.panaderia.system.service.PerfilesService;


@RestController
@RequestMapping("/api/v1/perfiles")
@CrossOrigin(origins = "*")
public class PerfilesController {

    @Autowired
    private PerfilesService perfilService;

    @GetMapping
    public List<Perfiles> buscarTodos() {
        return perfilService.buscarTodos();
    }

    @PostMapping
    public Perfiles guardar(@RequestBody Perfiles perfil) {
        perfilService.guardar(perfil);
        return perfil;
    }

    @PutMapping("/{id}")    
    public Perfiles modificar(@PathVariable Integer id, @RequestBody Perfiles perfil) {
        perfil.setIdPerfil(id); 
        perfilService.modificar(perfil);
        return perfil;
    }

    @GetMapping("/{idperfil}")
    public Optional<Perfiles> buscarId(@PathVariable("idperfil") Integer idperfil) {
        return perfilService.buscarId(idperfil);
    }

    @DeleteMapping("/{idperfil}")
    public String eliminar(@PathVariable("idperfil") Integer idperfil) {
        perfilService.eliminar(idperfil);
        return "Perfil eliminado";
    }

}
