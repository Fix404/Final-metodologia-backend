package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.example.final_metodologia_backend.entities.enums.Estado;

public class Detalle extends Base{
    @Column
    private String talle;

    @Column
    private Number stock;

    @Column
    private String color;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    // Clave foránea
    private Producto producto;

    public Detalle(String talle, Number stock, String color, Estado estado, Producto producto) {
        this.talle = talle;
        this.stock = stock;
        this.color = color;
        this.estado = estado;
        this.producto = producto;
    }
}
