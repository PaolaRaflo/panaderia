package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.ViewModulos;
import com.panaderia.system.service.ViewModulosService;


@RestController
@RequestMapping("/api/v1/view_modulos")
@CrossOrigin(origins = "*")
public class ViewModulosController {

    @Autowired
    private ViewModulosService viewModulosService;

    @GetMapping
    public List<ViewModulos> buscarTodos() {
        return viewModulosService.buscarTodos();
    }


    @GetMapping("/{idmodulo}")
    public Optional<ViewModulos> buscarId(@PathVariable("idmodulo") Integer idmodulo) {
        return viewModulosService.buscarId(idmodulo);
    }

  

}
