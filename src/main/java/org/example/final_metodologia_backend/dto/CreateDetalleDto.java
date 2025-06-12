package org.example.final_metodologia_backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.Estado;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateDetalleDto {


    @NotNull
    @Min(0)
    private Integer stock;

    @NotNull
    private Estado estado;

    @NotNull
    private Long talleId;

    @NotNull
    private Long colorId;

    @NotNull
    private Long precioId;

    @NotNull
    private Long productoId;

    private Integer version;
}
