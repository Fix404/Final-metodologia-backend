package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.ProductoCantidad;
import org.example.final_metodologia_backend.services.ProductoCantidadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto_cantidad")
public class ProductoCantidadController extends BaseController<ProductoCantidad, Long>{
    public ProductoCantidadController(ProductoCantidadService productoCantidadService){
        super(productoCantidadService);
    }
}
