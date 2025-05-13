package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.services.DetalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle")
public class DetalleController extends BaseController<Detalle, Long>{
    public DetalleController(DetalleService detalleService){
        super(detalleService);
    }
}
