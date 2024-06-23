package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.Cliente;
import com.panaderia.system.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        clienteService.guardar(cliente);
        return cliente;
    }

    @PutMapping
    public Cliente modificar(@RequestBody Cliente cliente) {
        clienteService.modificar(cliente);
        return cliente;
    }

    @GetMapping("/{idCliente}")
    public Optional<Cliente> buscarId(@PathVariable("idCliente") Integer idCliente) {
        return clienteService.buscarId(idCliente);
    }

    @DeleteMapping("/{idCliente}")
    public String eliminar(@PathVariable("idCliente") Integer idCliente) {
        clienteService.eliminar(idCliente);
        return "Cliente eliminado";
    }

}

