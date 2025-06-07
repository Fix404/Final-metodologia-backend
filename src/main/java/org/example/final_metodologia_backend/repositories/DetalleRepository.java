package org.example.final_metodologia_backend.repositories;

import org.example.final_metodologia_backend.entities.Detalle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends BaseRepository<Detalle, Long>{
    List<Detalle> findByProductoId(Long productoId);
}
