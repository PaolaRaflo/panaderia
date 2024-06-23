package com.panaderia.system.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Caja;
import com.panaderia.system.service.CajaService;


@RestController
@RequestMapping("/api/v1/cajas")
@CrossOrigin(origins = "*")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    @GetMapping
    public List<Caja> buscarTodos() {
        return cajaService.buscarTodos();
    }

    @PostMapping
    public Caja guardar(@RequestBody Caja caja) {
        cajaService.guardar(caja);
        return caja;
    }

    @PutMapping
    public Caja modificar(@RequestBody Caja caja) {
        cajaService.modificar(caja);
        return caja;
    }

    @GetMapping("/{idCaja}")
    public Optional<Caja> buscarId(@PathVariable("idCaja") Integer idCaja) {
        return cajaService.buscarId(idCaja);
    }

    @DeleteMapping("/{idCaja}")
    public String eliminar(@PathVariable("idCaja") Integer idCaja) {
        cajaService.eliminar(idCaja);
        return "Caja eliminada";
    }

}

