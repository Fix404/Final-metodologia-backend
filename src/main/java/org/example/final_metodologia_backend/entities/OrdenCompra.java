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
    @Column
    // Clave foránea
    private Usuario usuario;

    @Column
    private String fecha;

    @Column(name="precio_total")
    private float precioTotal;

    @Column
    @Enumerated(EnumType.STRING)
    private Movimiento movimiento;

    public OrdenCompra(Usuario usuario, String fecha, float precioTotal, Movimiento movimiento) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.movimiento = movimiento;
    }
}
