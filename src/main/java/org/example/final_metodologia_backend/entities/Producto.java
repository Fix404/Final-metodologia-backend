package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.final_metodologia_backend.entities.enums.SexoProducto;
import org.example.final_metodologia_backend.entities.enums.TipoProducto;

@Entity
@Table(name="productos")
@NoArgsConstructor
@Getter
@Setter
public class Producto extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @Column(name = "sexo_producto")
    @Enumerated(EnumType.STRING)
    private SexoProducto sexoProducto;

    public Producto(String nombre, String categoria, TipoProducto tipo, SexoProducto sexoProducto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.sexoProducto = sexoProducto;
    }
}
