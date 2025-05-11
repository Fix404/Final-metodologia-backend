package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="descuentos")
@NoArgsConstructor
@Getter
@Setter
public class Descuento extends Base{
    @Column
    private String fechaInicio;

    @Column
    private String fechaFin;

    @Column
    private Double porcentaje;

    public Descuento(String fechaInicio, String fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
