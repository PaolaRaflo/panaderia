package com.panaderia.system.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Sucursal;
import com.panaderia.system.service.SucursalService;

@RestController
@RequestMapping("/api/v1/sucursales")
@CrossOrigin(origins = "*")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping
    public List<Sucursal> buscarTodos() {
        return sucursalService.buscarTodos();
    }

    @PostMapping
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
        sucursalService.guardar(sucursal);
        return sucursal;
    }

    @PutMapping
    public Sucursal modificar(@RequestBody Sucursal sucursal) {
        sucursalService.modificar(sucursal);
        return sucursal;
    }

    @GetMapping("/{idSucursal}")
    public Optional<Sucursal> buscarId(@PathVariable("idSucursal") Integer idSucursal) {
        return sucursalService.buscarId(idSucursal);
    }

    @DeleteMapping("/{idSucursal}")
    public String eliminar(@PathVariable("idSucursal") Integer idSucursal) {
        sucursalService.eliminar(idSucursal);
        return "Sucursal eliminada";
    }

}

