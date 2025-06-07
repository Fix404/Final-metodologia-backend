package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.repositories.DetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleService extends BaseService<Detalle, Long> {

    private final DetalleRepository detalleRepository;

    public DetalleService(DetalleRepository detalleRepository) {
        super(detalleRepository);
        this.detalleRepository = detalleRepository; // Agregamos esta linea
    }

    public List<Detalle> obtenerDetallesPorProductoId(Long productoId) {
        return detalleRepository.findByProductoId(productoId);
    }
}

