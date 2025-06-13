package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="producto_cantidad")
@NoArgsConstructor
@Getter
@Setter
public class ProductoCantidad extends Base{

    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private Detalle detalle;

    @Column
    private Integer cantidad;

    public ProductoCantidad(Detalle detalle, Integer cantidad) {
        this.detalle = detalle;
        this.cantidad = cantidad;
    }
}
