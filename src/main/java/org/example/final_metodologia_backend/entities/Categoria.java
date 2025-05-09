package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="categorias")
@NoArgsConstructor
@Getter
@Setter
public class Categoria extends Base{
    @Column
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
