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
    private Double precioCompra;

    @Column(name="precio_venta")
    private Double precioVenta;

    public Precio(Double precioCompra, Double precioVenta) {
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }
}
