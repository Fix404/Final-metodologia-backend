package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Descuento;
import org.example.final_metodologia_backend.repositories.DescuentoRepository;
import org.springframework.stereotype.Service;

@Service
public class DescuentoService extends BaseService<Descuento, Long>{
    private DescuentoRepository descuentoRepository;

    public DescuentoService(DescuentoRepository descuentoRepository){
        super(descuentoRepository);
    }
}
