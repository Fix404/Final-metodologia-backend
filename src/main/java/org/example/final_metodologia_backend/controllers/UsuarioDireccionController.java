package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.UsuarioDireccion;
import org.example.final_metodologia_backend.services.UsuarioDireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direcciones_usuarios")
public class UsuarioDireccionController extends BaseController<UsuarioDireccion, Long>{
    public UsuarioDireccionController(UsuarioDireccionService usuarioDireccionService){
        super(usuarioDireccionService);
    }
}
