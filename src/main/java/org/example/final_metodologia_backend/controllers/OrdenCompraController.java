package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.OrdenCompra;
import org.example.final_metodologia_backend.services.OrdenCompraService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden_compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long>{
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        super(ordenCompraService);
    }
}
