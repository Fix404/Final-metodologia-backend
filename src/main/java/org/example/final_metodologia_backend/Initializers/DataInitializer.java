package org.example.final_metodologia_backend.Initializers;

import jakarta.persistence.EntityManager;
import org.example.final_metodologia_backend.entities.*;
import org.example.final_metodologia_backend.entities.enums.Estado;
import org.example.final_metodologia_backend.entities.enums.SexoProducto;
import org.example.final_metodologia_backend.entities.enums.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (!hayDatosIniciales()) {
            System.out.println("Cargando datos iniciales...");

            Categoria categoria1 = new Categoria("Urbano");
            Categoria categoria2 = new Categoria("Deportivo");
            entityManager.persist(categoria1);
            entityManager.persist(categoria2);

            Imagen imagen1 = new Imagen("URL imagen 1", "Descripcion 1");
            Imagen imagen2 = new Imagen("URL imagen 2", "Descripcion 2");
            entityManager.persist(imagen1);
            entityManager.persist(imagen2);

            Color color1 = new Color("Negro");
            Color color2 = new Color("Azul");
            Color color3 = new Color("Verde");
            entityManager.persist(color1);
            entityManager.persist(color2);
            entityManager.persist(color3);

            Descuento descuento1 = new Descuento(
                    LocalDate.of(2025, 6, 1),
                    LocalDate.of(2025, 6, 30),
                    15.0
            );
            Descuento descuento2 = new Descuento(
                    LocalDate.of(2025, 6, 6),
                    LocalDate.of(2025, 6, 28),
                    20.0
            );
            entityManager.persist(descuento1);
            entityManager.persist(descuento2);

            Localidad localidad1 = new Localidad("Las Heras", 5503);
            Localidad localidad2 = new Localidad("Godoy Cruz", 5501);
            Localidad localidad3 = new Localidad("Mendoza", 5500);
            entityManager.persist(localidad1);
            entityManager.persist(localidad2);
            entityManager.persist(localidad3);

            Direccion d1 = new Direccion(localidad1, "Perú", "Mendoza", 1125);
            Direccion d2 = new Direccion(localidad2, "Paso de los Andes", "Mendoza", 255);
            Direccion d3 = new Direccion(localidad3, "San Martin", "Mendoza", 156);
            entityManager.persist(d1);
            entityManager.persist(d2);
            entityManager.persist(d3);

            Precio precio1 = new Precio(53800.0, 62900.0);
            Precio precio2 = new Precio(72500.0, 75300.0);
            entityManager.persist(precio1);
            entityManager.persist(precio2);

            Talle talle1 = new Talle("S");
            Talle talle2 = new Talle("M");
            Talle talle3 = new Talle("L");
            entityManager.persist(talle1);
            entityManager.persist(talle2);
            entityManager.persist(talle3);

            Producto p1 = new Producto(
                    "Remera DryFit",
                    "Remera de entrenamiento de poliéster.",
                    categoria2,
                    imagen2,
                    descuento1,
                    TipoProducto.ROPA,
                    SexoProducto.UNISEX
            );
            entityManager.persist(p1);

            Producto p2 = new Producto(
                    "Zapatillas Running",
                    "Zapatillas livianas con buena amortiguación.",
                    categoria1,
                    imagen1,
                    descuento2,
                    TipoProducto.CALZADO,
                    SexoProducto.HOMBRE
            );
            entityManager.persist(p2);

            Producto p3 = new Producto(
                    "Zapatillas Nike Air Max",
                    "Zapatillas urbanas",
                    categoria1,
                    null,
                    null,
                    TipoProducto.CALZADO,
                    SexoProducto.MUJER
            );
            entityManager.persist(p3);

            Detalle detalle1 = new Detalle(
                    talle1,
                    15,
                    color1,
                    precio1,
                    Estado.DISPONIBLE,
                    p3
            );

            Detalle detalle2 = new Detalle(
                    talle2,
                    8,
                    color2,
                    precio2,
                    Estado.DISPONIBLE,
                    p3
            );

            entityManager.persist(detalle1);
            entityManager.persist(detalle2);

        } else {
            System.out.println("Datos ya existentes. Skipping carga.");
        }
    }

    private boolean hayDatosIniciales() {
        return existe(Categoria.class) ||
                existe(Imagen.class) ||
                existe(Color.class) ||
                existe(Descuento.class) ||
                existe(Localidad.class) ||
                existe(Direccion.class) ||
                existe(Precio.class) ||
                existe(Talle.class) ||
                existe(Producto.class) ||
                existe(Detalle.class);
    }

    private boolean existe(Class<?> clazz) {
        Long count = entityManager
                .createQuery("SELECT COUNT(e) FROM " + clazz.getSimpleName() + " e", Long.class)
                .getSingleResult();
        return count > 0;
    }
}
