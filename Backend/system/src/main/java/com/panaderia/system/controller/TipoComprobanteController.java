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
import com.panaderia.system.model.TipoComprobante;
import com.panaderia.system.service.TipoComprobanteService;

@RestController
@RequestMapping("/api/v1/tipos_comprobante")
@CrossOrigin(origins = "*")
public class TipoComprobanteController {

    @Autowired
    private TipoComprobanteService tipoComprobanteService;

    @GetMapping
    public List<TipoComprobante> buscarTodos() {
        return tipoComprobanteService.buscarTodos();
    }

    @PostMapping
    public TipoComprobante guardar(@RequestBody TipoComprobante tipoComprobante) {
        tipoComprobanteService.guardar(tipoComprobante);
        return tipoComprobante;
    }

    @PutMapping
    public TipoComprobante modificar(@PathVariable("idTipoComprobante") Integer idTipoComprobante, @RequestBody TipoComprobante tipoComprobante) {
    	tipoComprobante.setIdTipoComprobante(idTipoComprobante);
        tipoComprobanteService.modificar(tipoComprobante);
        return tipoComprobante;
    }
    

    @GetMapping("/{idTipoComprobante}")
    public Optional<TipoComprobante> buscarId(@PathVariable("idTipoComprobante") Integer idTipoComprobante) {
        return tipoComprobanteService.buscarId(idTipoComprobante);
    }

    @DeleteMapping("/{idTipoComprobante}")
    public String eliminar(@PathVariable("idTipoComprobante") Integer idTipoComprobante) {
        tipoComprobanteService.eliminar(idTipoComprobante);
        return "Tipo de comprobante eliminado";
    }
}

