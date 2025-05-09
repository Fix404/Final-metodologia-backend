package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.OrdenCompra;
import org.example.final_metodologia_backend.repositories.OrdenCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long>{
    private OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        super(ordenCompraRepository);
    }
}
