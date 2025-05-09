package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Direccion;
import org.example.final_metodologia_backend.repositories.DireccionRepository;
import org.springframework.stereotype.Service;

@Service
public class DireccionService extends BaseService<Direccion, Long>{
    private DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository){
        super(direccionRepository);
    }
}
