package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.final_metodologia_backend.entities.enums.SexoProducto;
import org.example.final_metodologia_backend.entities.enums.TipoProducto;

@Entity
@Table(name="productos")
public class Producto extends Base{
    @Column
    private String nombre;
    @Column
    private String categoria;
    @Column
    private Enum<TipoProducto> tipo;
    @Column
    private Enum<SexoProducto> sexoProducto;
}
