package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name="id_detalle")
    // Clave foránea
    private Detalle idDetalle;

    @Column
    // Clave foránea
    private Descuento descuento;

    public Precio(Float precioCompra, Float precioVenta, Detalle idDetalle, Descuento descuento) {
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.idDetalle = idDetalle;
        this.descuento = descuento;
    }
}
