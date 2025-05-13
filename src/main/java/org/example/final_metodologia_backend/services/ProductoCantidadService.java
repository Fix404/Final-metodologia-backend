package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.ProductoCantidad;
import org.example.final_metodologia_backend.repositories.ProductoCantidadRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoCantidadService extends BaseService<ProductoCantidad, Long>{
    private ProductoCantidadRepository productoCantidadRepository;

    public ProductoCantidadService(ProductoCantidadRepository productoCantidadRepository) {
        super(productoCantidadRepository);
    }
}
