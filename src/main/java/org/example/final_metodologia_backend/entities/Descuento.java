package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="descuentos")
@NoArgsConstructor
@Getter
@Setter
public class Descuento extends Base{
    @Column
    private LocalDate fechaInicio;

    @Column
    private LocalDate fechaFin;

    @Column
    private Double porcentaje;

    public Descuento(LocalDate fechaInicio, LocalDate fechaFin, Double porcentaje) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentaje = porcentaje;
    }
}
