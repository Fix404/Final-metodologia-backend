package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.Movimiento;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="orden_compra")
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompra extends Base{
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "orden_compra_producto_cantidad", // Tabla intermedia
            joinColumns = @JoinColumn(name = "orden_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_cantidad_id")
    )
    private List<ProductoCantidad> productoCantidad;

    @Column
    private Date fecha;

    @Column(name="precio_total")
    private float precioTotal;

    @Column
    @Enumerated(EnumType.STRING)
    private Movimiento movimiento;

    public OrdenCompra(Usuario usuario, Date fecha, List<ProductoCantidad> productoCantidad, float precioTotal, Movimiento movimiento) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.movimiento = movimiento;
        this.productoCantidad = productoCantidad;
    }
}
