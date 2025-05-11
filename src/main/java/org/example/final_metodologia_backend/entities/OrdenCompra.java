package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.Movimiento;

@Entity
@Table(name="orden_compra")
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompra extends Base{
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_cantidad_id")
    private ProductoCantidad productoCantidad;

    @Column
    private String fecha; //PODRIA SER DATE?

    @Column(name="precio_total")
    private float precioTotal;

    @Column
    @Enumerated(EnumType.STRING)
    private Movimiento movimiento;

    public OrdenCompra(Usuario usuario, String fecha,ProductoCantidad productoCantidad, float precioTotal, Movimiento movimiento) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.movimiento = movimiento;
        this.productoCantidad = productoCantidad;
    }
}
