package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.DetalleCompra;
import com.panaderia.system.service.DetalleCompraService;


@RestController
@RequestMapping("/api/v1/detalles_compra")
@CrossOrigin(origins = "*")
public class DetalleCompraController {

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public List<DetalleCompra> buscarTodos() {
        return detalleCompraService.buscarTodos();
    }

    @PostMapping
    public DetalleCompra guardar(@RequestBody DetalleCompra detalleCompra) {
        detalleCompraService.guardar(detalleCompra);
        return detalleCompra;
    }

    @PutMapping
    public DetalleCompra modificar(@RequestBody DetalleCompra detalleCompra) {
        detalleCompraService.modificar(detalleCompra);
        return detalleCompra;
    }

    @GetMapping("/{idDetalleCompra}")
    public Optional<DetalleCompra> buscarId(@PathVariable("idDetalleCompra") Integer idDetalleCompra) {
        return detalleCompraService.buscarId(idDetalleCompra);
    }

    @DeleteMapping("/{idDetalleCompra}")
    public String eliminar(@PathVariable("idDetalleCompra") Integer idDetalleCompra) {
        detalleCompraService.eliminar(idDetalleCompra);
        return "Detalle de compra eliminado";
    }
}
