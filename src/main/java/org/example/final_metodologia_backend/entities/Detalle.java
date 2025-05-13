package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import org.example.final_metodologia_backend.entities.enums.Estado;

public class Detalle extends Base{
    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "talle_id")
    private Talle talle;

    @OneToMany
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "precio_id")
    private Precio precio;

    @Column
    private Number stock;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Detalle(Talle talle, Number stock, Color color, Precio precio, Estado estado, Producto producto) {
        this.talle = talle;
        this.stock = stock;
        this.color = color;
        this.precio = precio;
        this.estado = estado;
        this.producto = producto;
    }
}
