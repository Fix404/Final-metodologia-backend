package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Descuento;
import org.example.final_metodologia_backend.services.DescuentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController extends BaseController<Descuento, Long>{
    public DescuentoController(DescuentoService descuentoService){
        super(descuentoService);
    }
}
