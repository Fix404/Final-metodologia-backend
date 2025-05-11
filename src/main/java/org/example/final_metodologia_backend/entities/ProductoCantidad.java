package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="producto_cantidad")
@NoArgsConstructor
@Getter
@Setter
public class ProductoCantidad extends Base{

    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column
    private Integer cantidad;

    public ProductoCantidad(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
