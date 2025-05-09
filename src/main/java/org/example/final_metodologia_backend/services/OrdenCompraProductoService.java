package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.OrdenCompraProducto;
import org.example.final_metodologia_backend.repositories.OrdenCompraProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraProductoService extends BaseService<OrdenCompraProducto, Long> {
    private OrdenCompraProductoRepository repository;
    public OrdenCompraProductoService(OrdenCompraProductoRepository ordenCompraProductoRepository) {
        super(ordenCompraProductoRepository);
    }
}
