package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Precio;
import org.example.final_metodologia_backend.repositories.PrecioRepository;
import org.springframework.stereotype.Service;

@Service
public class PrecioService extends BaseService<Precio, Long>{
    private PrecioRepository precioRepository;

    public PrecioService(PrecioRepository precioRepository) {
        super(precioRepository);
    }
}
