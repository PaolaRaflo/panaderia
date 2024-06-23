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
import com.panaderia.system.model.NumeroSerie;
import com.panaderia.system.service.NumeroSerieService;

@RestController
@RequestMapping("/api/v1/numeros_serie")
@CrossOrigin(origins = "*")
public class NumeroSerieController {

    @Autowired
    private NumeroSerieService numeroSerieService;

    @GetMapping
    public List<NumeroSerie> buscarTodos() {
        return numeroSerieService.buscarTodos();
    }

    @PostMapping
    public NumeroSerie guardar(@RequestBody NumeroSerie numeroSerie) {
        numeroSerieService.guardar(numeroSerie);
        return numeroSerie;
    }

    @PutMapping
    public NumeroSerie modificar(@RequestBody NumeroSerie numeroSerie) {
        numeroSerieService.modificar(numeroSerie);
        return numeroSerie;
    }

    @GetMapping("/{idNumeroSerie}")
    public Optional<NumeroSerie> buscarId(@PathVariable("idNumeroSerie") Integer idNumeroSerie) {
        return numeroSerieService.buscarId(idNumeroSerie);
    }

    @DeleteMapping("/{idNumeroSerie}")
    public String eliminar(@PathVariable("idNumeroSerie") Integer idNumeroSerie) {
        numeroSerieService.eliminar(idNumeroSerie);
        return "Número de serie eliminado";
    }
}

