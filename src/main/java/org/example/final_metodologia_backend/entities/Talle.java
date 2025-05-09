package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="talles")
@NoArgsConstructor
@Getter
@Setter
public class Talle extends Base{
    @Column
    private String talle;

    public Talle(String talle) {
        this.talle = talle;
    }
}
