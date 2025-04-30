package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Producto;
import org.example.final_metodologia_backend.services.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController extends BaseController<Producto, Long>{
    public ProductoController(ProductoService productoService){
        super(productoService);
    }
}
