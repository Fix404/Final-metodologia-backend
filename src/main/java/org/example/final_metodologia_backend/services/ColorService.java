package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Color;
import org.example.final_metodologia_backend.repositories.ColorRepository;
import org.springframework.stereotype.Service;

@Service
public class ColorService extends BaseService<Color, Long>{
    private ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository){
        super(colorRepository);
    }
}
