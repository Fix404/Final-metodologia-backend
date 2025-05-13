package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.repositories.DetalleRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleService extends BaseService<Detalle, Long>{
    private DetalleRepository detalleRepository;

    public DetalleService(DetalleRepository detalleRepository){
        super(detalleRepository);
    }
}
