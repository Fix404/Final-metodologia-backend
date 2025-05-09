package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Long>{
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        super(repository);
    }
}
