package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Compra;
import com.panaderia.system.model.DetalleCompra;
import com.panaderia.system.service.CompraService;
import com.panaderia.system.service.DetalleCompraService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/compras")
@CrossOrigin(origins = "*")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public List<Compra> buscarTodos() {
        return compraService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<?> guardarCompra(@RequestBody Compra compra) {
        compraService.guardar(compra);
        for (DetalleCompra detalle : compra.getDetalleCompras()) {
            detalle.setCompra(compra);
            detalleCompraService.guardar(detalle);
        }
        return ResponseEntity.ok().body("Compra y detalles guardados exitosamente");
    }

    @GetMapping("/{idCompra}")
    public ResponseEntity<Compra> buscarId(@PathVariable("idCompra") Integer idCompra) {
        Optional<Compra> compra = compraService.buscarId(idCompra);
        return compra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idCompra}")
    public ResponseEntity<?> eliminar(@PathVariable("idCompra") Integer idCompra) {
        compraService.eliminar(idCompra);
        return ResponseEntity.ok().body("Compra eliminada");
    }
}
