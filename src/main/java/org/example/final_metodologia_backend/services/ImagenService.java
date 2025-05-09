package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Imagen;
import org.example.final_metodologia_backend.repositories.ImagenRepository;
import org.springframework.stereotype.Service;

@Service
public class ImagenService extends BaseService<Imagen, Long>{
    private ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository){
        super(imagenRepository);
    }
}
