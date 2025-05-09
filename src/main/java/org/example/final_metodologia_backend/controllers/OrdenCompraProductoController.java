package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.OrdenCompraProducto;
import org.example.final_metodologia_backend.services.OrdenCompraProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden_compra_producto")
public class OrdenCompraProductoController extends BaseController<OrdenCompraProducto, Long>{
    public OrdenCompraProductoController(OrdenCompraProductoService ordenCompraProductoService) {
        super(ordenCompraProductoService);
    }
}
