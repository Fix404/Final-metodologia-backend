package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Talle;
import org.example.final_metodologia_backend.repositories.TalleRepository;
import org.springframework.stereotype.Service;

@Service
public class TalleService extends BaseService<Talle, Long>{
    private TalleRepository talleRepository;

    public TalleService(TalleRepository talleRepository){
        super(talleRepository);
    }
}
