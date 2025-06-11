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

            Imagen imagen1 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749602973/images_dnx9yz.jpg", "Descripcion 1");
            Imagen imagen2 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749603017/images_1_edkgr3.jpg", "Descripcion 2");
            Imagen imagen3 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749605002/zapatillas-nike-air-max-systm-negra-510010dm9537001-1_elsnan.jpg", "Descripcion 3");
            Imagen imagen4 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749602954/descarga_1_ybnohb.jpg", "Descripcion 4");
            Imagen imagen5 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749602972/descarga_3_gieexi.jpg", "Descripcion 5");
            Imagen imagen6 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749602972/descarga_2_lwphr4.jpg", "Descripcion 6");
            Imagen imagen7 = new Imagen("https://res.cloudinary.com/dapt6ypui/image/upload/v1749603039/images_2_oanobl.jpg", "Descripcion 7");
            entityManager.persist(imagen1);
            entityManager.persist(imagen2);
            entityManager.persist(imagen3);
            entityManager.persist(imagen4);
            entityManager.persist(imagen5);
            entityManager.persist(imagen6);
            entityManager.persist(imagen7);


            Color colorBlanco = new Color("Blanco");
            Color colorNegro = new Color("Negro");
            Color colorRojo = new Color("Rojo");
            Color colorAzul = new Color("Azul");
            Color colorVerde = new Color("Verde");
            Color colorRosa = new Color("Rosa");
            Color colorGris = new Color("Gris");
            Color colorAmarillo = new Color("Amarillo");
            Color colorNaranja = new Color("Naranja");
            Color colorMarron = new Color("Marrón");
            entityManager.persist(colorBlanco);
            entityManager.persist(colorNegro);
            entityManager.persist(colorRojo);
            entityManager.persist(colorAzul);
            entityManager.persist(colorVerde);
            entityManager.persist(colorRosa);
            entityManager.persist(colorGris);
            entityManager.persist(colorAmarillo);
            entityManager.persist(colorNaranja);
            entityManager.persist(colorMarron);


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
            Precio precio3 = new Precio(61200.0, 68000.0);
            Precio precio4 = new Precio(47000.0, 55000.0);
            Precio precio5 = new Precio(80000.0, 89000.0);
            Precio precio6 = new Precio(90000.0, 102000.0);
            entityManager.persist(precio1);
            entityManager.persist(precio2);
            entityManager.persist(precio3);
            entityManager.persist(precio4);
            entityManager.persist(precio5);
            entityManager.persist(precio6);


            // Talles de ropa
            Talle talleS = new Talle("S");
            Talle talleM = new Talle("M");
            Talle talleL = new Talle("L");
            Talle talleXL = new Talle("XL");
            entityManager.persist(talleS);
            entityManager.persist(talleM);
            entityManager.persist(talleL);
            entityManager.persist(talleXL);

            // Talles de zapatillas
            Talle talle36 = new Talle("36");
            Talle talle37 = new Talle("37");
            Talle talle38 = new Talle("38");
            Talle talle39 = new Talle("39");
            Talle talle40 = new Talle("40");
            Talle talle41 = new Talle("41");
            Talle talle42 = new Talle("42");
            entityManager.persist(talle36);
            entityManager.persist(talle37);
            entityManager.persist(talle38);
            entityManager.persist(talle39);
            entityManager.persist(talle40);
            entityManager.persist(talle41);
            entityManager.persist(talle42);


            Producto p1 = new Producto(
                    "Remera DryFit",
                    "Remera de entrenamiento de poliéster.",
                    categoria2,
                    imagen1,
                    descuento1,
                    TipoProducto.ROPA,
                    SexoProducto.UNISEX
            );
            entityManager.persist(p1);

            Producto p2 = new Producto(
                    "Zapatillas Adidas Running",
                    "Zapatillas livianas con buena amortiguación.",
                    categoria2,
                    imagen2,
                    descuento2,
                    TipoProducto.CALZADO,
                    SexoProducto.MUJER
            );
            entityManager.persist(p2);

            Producto p3 = new Producto(
                    "Zapatillas Nike Air Max",
                    "Zapatillas urbanas",
                    categoria1,
                    imagen3,
                    null,
                    TipoProducto.CALZADO,
                    SexoProducto.HOMBRE
            );
            entityManager.persist(p3);

            Producto p4 = new Producto(
                    "Zapatillas Puma Suede Classic",
                    "Zapatillas urbanas",
                    categoria1,
                    imagen4,
                    null,
                    TipoProducto.CALZADO,
                    SexoProducto.UNISEX
            );
            entityManager.persist(p4);

            Producto p5 = new Producto(
                    "Campera Nike ProSport",
                    "Campera deportiva",
                    categoria2,
                    imagen5,
                    null,
                    TipoProducto.ROPA,
                    SexoProducto.UNISEX
            );
            entityManager.persist(p5);

            Producto p6 = new Producto(
                    "Corpiño deportivo",
                    "Corpiño con tecnología dry-fit",
                    categoria2,
                    imagen6,
                    null,
                    TipoProducto.ROPA,
                    SexoProducto.MUJER
            );
            entityManager.persist(p6);

            Producto p7 = new Producto(
                    "Camiseta Argentina",
                    "Camiseta de la Selección",
                    categoria2,
                    imagen7,
                    descuento1,
                    TipoProducto.ROPA,
                    SexoProducto.UNISEX
            );
            entityManager.persist(p7);

            Detalle detalle1 = new Detalle(talleS, 10, colorNegro, precio1, Estado.DISPONIBLE, p1);
            Detalle detalle2 = new Detalle(talleM, 8, colorNegro, precio1, Estado.DISPONIBLE, p1);
            Detalle detalle3 = new Detalle(talleL, 6, colorNegro, precio2, Estado.DISPONIBLE, p1);
            Detalle detalle4 = new Detalle(talleXL, 5, colorNegro, precio2, Estado.DISPONIBLE, p1);
            Detalle detalle5 = new Detalle(talleS, 9, colorNaranja, precio1, Estado.DISPONIBLE, p1);
            Detalle detalle6 = new Detalle(talleM, 7, colorNaranja, precio2, Estado.DISPONIBLE, p1);
            Detalle detalle7 = new Detalle(talleL, 6, colorNaranja, precio3, Estado.DISPONIBLE, p1);
            Detalle detalle8 = new Detalle(talleXL, 4, colorNaranja, precio3, Estado.DISPONIBLE, p1);
            Detalle detalle9 = new Detalle(talleS, 11, colorVerde, precio1, Estado.DISPONIBLE, p1);
            Detalle detalle10 = new Detalle(talleM, 10, colorVerde, precio2, Estado.DISPONIBLE, p1);
            Detalle detalle11 = new Detalle(talleL, 7, colorVerde, precio2, Estado.DISPONIBLE, p1);
            Detalle detalle12 = new Detalle(talleXL, 3, colorVerde, precio3, Estado.DISPONIBLE, p1);
            entityManager.persist(detalle1);
            entityManager.persist(detalle2);
            entityManager.persist(detalle3);
            entityManager.persist(detalle4);
            entityManager.persist(detalle5);
            entityManager.persist(detalle6);
            entityManager.persist(detalle7);
            entityManager.persist(detalle8);
            entityManager.persist(detalle9);
            entityManager.persist(detalle10);
            entityManager.persist(detalle11);
            entityManager.persist(detalle12);

            Detalle detalle13 = new Detalle(talle36, 10, colorVerde, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle14 = new Detalle(talle37, 12, colorVerde, precio2, Estado.DISPONIBLE, p2);
            Detalle detalle15 = new Detalle(talle38, 8, colorVerde, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle16 = new Detalle(talle39, 6, colorVerde, precio2, Estado.DISPONIBLE, p2);
            Detalle detalle17 = new Detalle(talle36, 9, colorGris, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle18 = new Detalle(talle37, 7, colorGris, precio2, Estado.DISPONIBLE, p2);
            Detalle detalle19 = new Detalle(talle38, 11, colorGris, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle20 = new Detalle(talle39, 5, colorGris, precio2, Estado.DISPONIBLE, p2);
            Detalle detalle21 = new Detalle(talle36, 13, colorRosa, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle22 = new Detalle(talle37, 10, colorRosa, precio2, Estado.DISPONIBLE, p2);
            Detalle detalle23 = new Detalle(talle38, 14, colorRosa, precio1, Estado.DISPONIBLE, p2);
            Detalle detalle24 = new Detalle(talle39, 6, colorRosa, precio2, Estado.DISPONIBLE, p2);
            entityManager.persist(detalle13);
            entityManager.persist(detalle14);
            entityManager.persist(detalle15);
            entityManager.persist(detalle16);
            entityManager.persist(detalle17);
            entityManager.persist(detalle18);
            entityManager.persist(detalle19);
            entityManager.persist(detalle20);
            entityManager.persist(detalle21);
            entityManager.persist(detalle22);
            entityManager.persist(detalle23);
            entityManager.persist(detalle24);

            Detalle detalle25 = new Detalle(talle36, 20, colorNegro, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle26 = new Detalle(talle37, 15, colorNegro, precio2, Estado.DISPONIBLE, p3);
            Detalle detalle27 = new Detalle(talle38, 18, colorNegro, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle28 = new Detalle(talle39, 10, colorNegro, precio2, Estado.DISPONIBLE, p3);
            Detalle detalle29 = new Detalle(talle36, 12, colorBlanco, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle30 = new Detalle(talle37, 14, colorBlanco, precio2, Estado.DISPONIBLE, p3);
            Detalle detalle31 = new Detalle(talle38, 16, colorBlanco, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle32 = new Detalle(talle39, 8, colorBlanco, precio2, Estado.DISPONIBLE, p3);
            Detalle detalle33 = new Detalle(talle36, 11, colorMarron, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle34 = new Detalle(talle37, 9, colorMarron, precio2, Estado.DISPONIBLE, p3);
            Detalle detalle35 = new Detalle(talle38, 13, colorMarron, precio1, Estado.DISPONIBLE, p3);
            Detalle detalle36 = new Detalle(talle39, 7, colorMarron, precio2, Estado.DISPONIBLE, p3);
            entityManager.persist(detalle25);
            entityManager.persist(detalle26);
            entityManager.persist(detalle27);
            entityManager.persist(detalle28);
            entityManager.persist(detalle29);
            entityManager.persist(detalle30);
            entityManager.persist(detalle31);
            entityManager.persist(detalle32);
            entityManager.persist(detalle33);
            entityManager.persist(detalle34);
            entityManager.persist(detalle35);
            entityManager.persist(detalle36);


            Detalle detalle37 = new Detalle(talle36, 16, colorVerde, precio1, Estado.DISPONIBLE, p4);
            Detalle detalle38 = new Detalle(talle37, 11, colorVerde, precio2, Estado.DISPONIBLE, p4);
            Detalle detalle39 = new Detalle(talle38, 15, colorVerde, precio1, Estado.DISPONIBLE, p4);
            Detalle detalle40 = new Detalle(talle39, 13, colorVerde, precio2, Estado.DISPONIBLE, p4);
            Detalle detalle41 = new Detalle(talle36, 8, colorGris, precio1, Estado.DISPONIBLE, p4);
            Detalle detalle42 = new Detalle(talle37, 7, colorGris, precio2, Estado.DISPONIBLE, p4);
            Detalle detalle43 = new Detalle(talle38, 6, colorGris, precio1, Estado.DISPONIBLE, p4);
            Detalle detalle44 = new Detalle(talle39, 5, colorGris, precio2, Estado.DISPONIBLE, p4);
            entityManager.persist(detalle37);
            entityManager.persist(detalle38);
            entityManager.persist(detalle39);
            entityManager.persist(detalle40);
            entityManager.persist(detalle41);
            entityManager.persist(detalle42);
            entityManager.persist(detalle43);
            entityManager.persist(detalle44);

            Detalle detalle45 = new Detalle(talleM, 18, colorGris, precio2, Estado.DISPONIBLE, p5);
            Detalle detalle46 = new Detalle(talleL, 15, colorGris, precio1, Estado.DISPONIBLE, p5);
            Detalle detalle47 = new Detalle(talleXL, 10, colorGris, precio2, Estado.DISPONIBLE, p5);
            Detalle detalle48 = new Detalle(talleS, 12, colorNaranja, precio1, Estado.DISPONIBLE, p5);
            Detalle detalle49 = new Detalle(talleM, 14, colorNaranja, precio2, Estado.DISPONIBLE, p5);
            Detalle detalle50 = new Detalle(talleL, 16, colorNaranja, precio1, Estado.DISPONIBLE, p5);
            Detalle detalle51 = new Detalle(talleXL, 9, colorNaranja, precio2, Estado.DISPONIBLE, p5);
            Detalle detalle52 = new Detalle(talleS, 11, colorAzul, precio1, Estado.DISPONIBLE, p5);
            Detalle detalle53 = new Detalle(talleM, 13, colorAzul, precio2, Estado.DISPONIBLE, p5);
            Detalle detalle54 = new Detalle(talleL, 17, colorAzul, precio1, Estado.DISPONIBLE, p5);
            Detalle detalle55 = new Detalle(talleXL, 8, colorAzul, precio2, Estado.DISPONIBLE, p5);
            entityManager.persist(detalle45);
            entityManager.persist(detalle46);
            entityManager.persist(detalle47);
            entityManager.persist(detalle48);
            entityManager.persist(detalle49);
            entityManager.persist(detalle50);
            entityManager.persist(detalle51);
            entityManager.persist(detalle52);
            entityManager.persist(detalle53);
            entityManager.persist(detalle54);
            entityManager.persist(detalle55);

            Detalle detalle56 = new Detalle(talleS, 14, colorRosa, precio1, Estado.DISPONIBLE, p6);
            Detalle detalle57 = new Detalle(talleM, 12, colorMarron, precio2, Estado.DISPONIBLE, p6);
            Detalle detalle58 = new Detalle(talleL, 10, colorBlanco, precio1, Estado.DISPONIBLE, p6);
            Detalle detalle59 = new Detalle(talleXL, 8, colorRosa, precio2, Estado.DISPONIBLE, p6);
            Detalle detalle60 = new Detalle(talleS, 9, colorMarron, precio1, Estado.DISPONIBLE, p6);
            entityManager.persist(detalle56);
            entityManager.persist(detalle57);
            entityManager.persist(detalle58);
            entityManager.persist(detalle59);
            entityManager.persist(detalle60);

            Detalle detalle61 = new Detalle(talleS, 11, colorNegro, precio1, Estado.DISPONIBLE, p7);
            Detalle detalle62 = new Detalle(talleM, 13, colorBlanco, precio2, Estado.DISPONIBLE, p7);
            Detalle detalle63 = new Detalle(talleL, 9, colorAzul, precio1, Estado.DISPONIBLE, p7);
            Detalle detalle64 = new Detalle(talleXL, 7, colorNegro, precio2, Estado.DISPONIBLE, p7);
            Detalle detalle65 = new Detalle(talleS, 10, colorBlanco, precio1, Estado.DISPONIBLE, p7);
            Detalle detalle66 = new Detalle(talleM, 12, colorAzul, precio2, Estado.DISPONIBLE, p7);
            entityManager.persist(detalle61);
            entityManager.persist(detalle62);
            entityManager.persist(detalle63);
            entityManager.persist(detalle64);
            entityManager.persist(detalle65);
            entityManager.persist(detalle66);

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
