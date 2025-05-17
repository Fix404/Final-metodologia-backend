package org.example.final_metodologia_backend.dataInitializer;

import org.example.final_metodologia_backend.entities.Producto;
import org.example.final_metodologia_backend.entities.enums.SexoProducto;
import org.example.final_metodologia_backend.entities.enums.TipoProducto;
import org.example.final_metodologia_backend.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    @Autowired
    public DataInitializer(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Comprobar si ya hay datos para evitar duplicados
        try{
            if (productoRepository.count() == 0) {
                Producto producto = new Producto("Producto 1", "Un nuevo producto", null, null,null , null, SexoProducto.UNISEX);
                productoRepository.save(producto);
                System.out.println("Producto guardado con éxito!");
            } else {
                System.out.println("La base de datos ya contiene productos, no se insertaron nuevos datos.");
            }
        }catch(Exception e) {
            throw new RuntimeException("Error al inicializar los datos", e);
        }
    }
}