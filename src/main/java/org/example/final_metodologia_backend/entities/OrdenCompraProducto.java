package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orden_compra_producto")
@NoArgsConstructor
@Getter
@Setter
public class OrdenCompraProducto extends Base{
    @Column(name="id_producto")
    // Clave foránea
    private Producto idProducto;

    @Column
    private Integer cantidad;

    public OrdenCompraProducto(Producto idProducto, Integer cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
}
