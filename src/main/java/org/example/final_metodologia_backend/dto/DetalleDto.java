package org.example.final_metodologia_backend.dto;
import org.example.final_metodologia_backend.entities.enums.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleDto {
    private Long id;
    private Integer stock;
    private Estado estado;
    private String talle;
    private String color;
    private Double precioVenta;
    private String nombreProducto;
}

