package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Imagen;
import org.example.final_metodologia_backend.entities.Localidad;
import org.example.final_metodologia_backend.services.ImagenService;
import org.example.final_metodologia_backend.services.LocalidadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/localidades")
public class LocalidadController extends BaseController<Localidad, Long>{
    public LocalidadController(LocalidadService localidadService){
        super(localidadService);
    }
}
