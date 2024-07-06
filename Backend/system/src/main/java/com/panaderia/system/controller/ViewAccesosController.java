package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.ViewAccesos;
import com.panaderia.system.service.ViewAccesosService;


@RestController
@RequestMapping("/api/v1/view_accesos")
@CrossOrigin(origins = "*")
public class ViewAccesosController {

    @Autowired
    private ViewAccesosService ViewAccesosService;

    @GetMapping
    public List<ViewAccesos> buscarTodos() {
        return ViewAccesosService.buscarTodos();
    }


    @GetMapping("/{idacceso}")
    public Optional<ViewAccesos> buscarId(@PathVariable("idacceso") Integer idacceso) {
        return ViewAccesosService.buscarId(idacceso);
    }

  

}
