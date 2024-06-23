package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.DetalleVenta;
import com.panaderia.system.service.DetalleVentaService;


@RestController
@RequestMapping("/api/v1/detalles_venta")
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> buscarTodos() {
        return detalleVentaService.buscarTodos();
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        detalleVentaService.guardar(detalleVenta);
        return detalleVenta;
    }
/* 
    @PutMapping
    public DetalleVenta modificar(@RequestBody DetalleVenta detalleVenta) {
        detalleVentaService.;
        return detalleVenta;
    }
 */
    @GetMapping("/{id}")
    public Optional<DetalleVenta> buscarId(@PathVariable("id") Integer id) {
        return detalleVentaService.buscarId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        detalleVentaService.eliminar(id);
        return "Detalle de venta eliminado";
    }

}
