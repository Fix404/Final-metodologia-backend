package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.UsuarioDireccion;
import org.example.final_metodologia_backend.repositories.UsuarioDireccionRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDireccionService extends BaseService<UsuarioDireccion, Long>{
    private UsuarioDireccionRepository usuarioDireccionRepository;

    public UsuarioDireccionService(UsuarioDireccionRepository usuarioDireccionRepository){
        super(usuarioDireccionRepository);
    }
}
