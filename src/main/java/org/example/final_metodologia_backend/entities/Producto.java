package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.SexoProducto;
import org.example.final_metodologia_backend.entities.enums.TipoProducto;

import java.io.Serializable;

@Entity
@Table(name="productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Producto extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "tipo")
    private Enum<TipoProducto> tipo;

    @Column(name = "sexo_producto")
    private Enum<SexoProducto> sexoProducto;

}
