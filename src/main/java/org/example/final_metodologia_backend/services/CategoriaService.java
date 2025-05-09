package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Categoria;
import org.example.final_metodologia_backend.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends BaseService<Categoria, Long>{
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        super(categoriaRepository);
    }
}
