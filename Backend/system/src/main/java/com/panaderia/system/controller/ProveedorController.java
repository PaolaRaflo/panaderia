package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Proveedor;
import com.panaderia.system.service.ProveedorService;

@RestController
@RequestMapping("/api/v1/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> buscarTodos() {
        return proveedorService.buscarTodos();
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        proveedorService.guardar(proveedor);
        return proveedor;
    }

    @PutMapping
    public Proveedor modificar(@RequestBody Proveedor proveedor) {
        proveedorService.modificar(proveedor);
        return proveedor;
    }

    @GetMapping("/{idProveedor}")
    public Optional<Proveedor> buscarId(@PathVariable("idProveedor") Integer idProveedor) {
        return proveedorService.buscarId(idProveedor);
    }

    @DeleteMapping("/{idProveedor}")
    public String eliminar(@PathVariable("idProveedor") Integer idProveedor) {
        proveedorService.eliminar(idProveedor);
        return "Proveedor eliminado";
    }

}

