package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="precios")
@NoArgsConstructor
@Getter
@Setter
public class Precio extends Base{
    @Column(name="precio_compra")
    private Float precioCompra;

    @Column(name="precio_venta")
    private Float precioVenta;

    @Column(name="detalle_id")
    // Clave foránea
    private Detalle idDetalle;

    //¿Es ManyToOne?
    @ManyToOne
    @JoinColumn(name="descuento_id")
    private Descuento descuento;

    public Precio(Float precioCompra, Float precioVenta, Detalle idDetalle, Descuento descuento) {
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.idDetalle = idDetalle;
        this.descuento = descuento;
    }
}
