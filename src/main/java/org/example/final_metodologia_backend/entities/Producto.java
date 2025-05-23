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

    @Column
    private String descripcion;

    @ManyToOne // ANTES ONETOMANY
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;

    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuento;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    @Column(name = "sexo_producto")
    @Enumerated(EnumType.STRING)
    private SexoProducto sexoProducto;

    public Producto(String nombre, String descripcion, Categoria categoria, Imagen imagen, Descuento descuento, TipoProducto tipo, SexoProducto sexoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.sexoProducto = sexoProducto;
        this.descuento = descuento;
        this.imagen = imagen;
    }
}
