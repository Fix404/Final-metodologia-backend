package org.example.final_metodologia_backend.repositories;

import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.entities.ProductoCantidad;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoCantidadRepository extends BaseRepository<ProductoCantidad, Long>{
    Optional<ProductoCantidad> findByDetalleAndCantidad(Detalle detalle, Integer cantidad);}
