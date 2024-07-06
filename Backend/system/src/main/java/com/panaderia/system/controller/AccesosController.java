package com.panaderia.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.panaderia.system.model.Accesos;
import com.panaderia.system.service.AccesosService;

@RestController
@RequestMapping("/api/v1/accesos")
@CrossOrigin(origins = "*")
public class AccesosController {

    @Autowired
    private AccesosService accesoService;

    @GetMapping
    public List<Accesos> buscarTodos() {
        return accesoService.buscarTodos();
    }

    @PostMapping
    @ResponseBody
    public Accesos guardar(@RequestBody FormData formData) {

        Accesos acceso = null;
    
        // for (String idmodulo : datos.getIdModulo()) {
        //     acceso = new Accesos();
        //     acceso.setIdPerfil(Integer.parseInt((datos.getIdPerfil())));
        //     acceso.setIdModulo(Integer.parseInt(idmodulo));
        //     accesoService.guardar(acceso);
        // }
        if(formData.getIdmodulos() != null) {
            String[] idmodulos_array = formData.getIdmodulos().split(",");
            for (int i = 0; i < idmodulos_array.length; i++) {
                acceso = new Accesos();
                acceso.setIdPerfil(Integer.parseInt((formData.getIdperfil())));
                acceso.setIdModulo(Integer.parseInt(idmodulos_array[i]));
                accesoService.guardar(acceso);
            }
        }
        
        
        return acceso;
    }

    @PutMapping("/{id}")    
    public Accesos modificar(@PathVariable Integer id, @RequestBody Accesos acceso) {
        acceso.setIdPerfil(id); 
        accesoService.modificar(acceso);
        return acceso;
    }

    @GetMapping("/{idacceso}")
    public Optional<Accesos> buscarId(@PathVariable("idacceso") Integer idacceso) {
        return accesoService.buscarId(idacceso);
    }

    // @DeleteMapping("/{idacceso}")
    // public String eliminar(@PathVariable("idacceso") Integer idacceso) {
    //     accesoService.eliminar(idacceso);
    //     return "Acceso eliminado";
    // }

    @DeleteMapping("/{idperfil}")
    public ResponseEntity<String> deleteAccesosByIdperfil(@PathVariable Integer idperfil) {
        accesoService.deleteAccesosByIdperfil(idperfil);
        return ResponseEntity.ok("Accesos eliminados");
        //return ResponseEntity.noContent().build();
    }


    public static class FormData {
        private String idperfil;
        private String idmodulos;

        // getters y setters
        public String getIdperfil() {
            return idperfil;
        }

        public void setIdperfil(String idperfil) {
            this.idperfil = idperfil;
        }

        public String getIdmodulos() {
            return idmodulos;
        }

        public void setIdmodulos(String idmodulos) {
            this.idmodulos = idmodulos;
        }
    }

}


