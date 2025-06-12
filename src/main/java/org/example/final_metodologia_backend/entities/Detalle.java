package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.Estado;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173") //HCER GLOBAL
@Entity
@Table(name = "detalle") // ANTES NO ESTABAN ESTAS NOTACIONES
@NoArgsConstructor
@Getter
@Setter
public class Detalle extends Base{
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Precio precio;

    @Column
    private Integer stock;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Detalle(Talle talle, Integer stock, Color color, Precio precio, Estado estado, Producto producto) {
        this.talle = talle;
        this.stock = stock;
        this.color = color;
        this.precio = precio;
        this.estado = estado;
        this.producto = producto;
    }
}
