package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="localidad")
@NoArgsConstructor
@Setter
@Getter
public class Localidad extends Base{

    @Column
    private String localidad;

    @Column
    private Integer codigoPostal;

    public Localidad(String localidad, Integer codigoPostal) {
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }
}
