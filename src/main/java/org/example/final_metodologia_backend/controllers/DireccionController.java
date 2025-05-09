package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Direccion;
import org.example.final_metodologia_backend.services.DireccionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direcciones")
public class DireccionController extends BaseController<Direccion, Long>{
    public DireccionController(DireccionService direccionService){
        super(direccionService);
    }
}
