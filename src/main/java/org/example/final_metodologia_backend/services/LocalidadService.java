package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Localidad;
import org.example.final_metodologia_backend.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalidadService extends BaseService<Localidad, Long>{
    private LocalidadRepository localidadRepository;

    public LocalidadService(LocalidadRepository localidadRepository){
        super(localidadRepository);
    }
}
