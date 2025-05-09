package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Precio;
import org.example.final_metodologia_backend.services.PrecioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/precios")
public class PrecioController extends BaseController<Precio, Long>{
    public PrecioController(PrecioService precioService){
        super(precioService);
    }
}
