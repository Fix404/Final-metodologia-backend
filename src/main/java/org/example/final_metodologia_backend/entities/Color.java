package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="color")
@NoArgsConstructor
@Getter
@Setter
public class Color extends Base{
    @Column
    private String color;

    public Color(String color) {
        this.color = color;
    }
}
