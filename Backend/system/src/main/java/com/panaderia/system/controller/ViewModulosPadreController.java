package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.panaderia.system.model.ViewModulosPadre;
import com.panaderia.system.service.ViewModulosPadreService;


@RestController
@RequestMapping("/api/v1/view_modulos_padre")
@CrossOrigin(origins = "*")
public class ViewModulosPadreController {

    @Autowired
    private ViewModulosPadreService viewModulosPadreService;

    @GetMapping
    public List<ViewModulosPadre> buscarTodos() {
        return viewModulosPadreService.buscarTodos();
    }


    @GetMapping("/{idmodulo}")
    public Optional<ViewModulosPadre> buscarId(@PathVariable("idmodulo") Integer idmodulo) {
        return viewModulosPadreService.buscarId(idmodulo);
    }

  

}
