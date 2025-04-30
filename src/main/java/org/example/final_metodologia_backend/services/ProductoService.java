package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Producto;
import org.example.final_metodologia_backend.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseService<Producto, Long>{
    public ProductoService(ProductoRepository productoRepository) {

        super (productoRepository);}
}
