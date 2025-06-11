package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="direcciones")
@NoArgsConstructor
@Getter
@Setter
public class Direccion extends Base{
    @ManyToOne
    @JoinColumn (name = "localidad_id")
    private Localidad localidad;

    @Column
    private String calle;

    @Column
    private String provincia;

    @Column
    private Integer numero;

    public Direccion(Localidad localidad, String calle, String provincia, Integer numero) {
        this.localidad = localidad;
        this.calle = calle;
        this.provincia = provincia;
        this.numero = numero;
    }
}
