package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="direcciones")
@NoArgsConstructor
@Getter
@Setter
public class Direccion extends Base{
    @Column
    private String localidad;

    @Column
    private String pais;

    @Column
    private String provincia;

    @Column
    private String departamento;

    public Direccion(String localidad, String pais, String provincia, String departamento) {
        this.localidad = localidad;
        this.pais = pais;
        this.provincia = provincia;
        this.departamento = departamento;
    }
}
