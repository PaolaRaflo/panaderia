package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Producto;
import com.panaderia.system.service.ProductoService;


@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> buscarTodos() {
        return productoService.buscarTodos();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        productoService.guardar(producto);
        return producto;
    }

    @PutMapping
    public Producto modificar(@RequestBody Producto producto) {
        productoService.modificar(producto);
        return producto;
    }

    @GetMapping("/{idProducto}")
    public Optional<Producto> buscarId(@PathVariable("idProducto") Integer idProducto) {
        return productoService.buscarId(idProducto);
    }

    @DeleteMapping("/{idProducto}")
    public String eliminar(@PathVariable("idProducto") Integer idProducto) {
        productoService.eliminar(idProducto);
        return "Producto eliminado";
    }

}

