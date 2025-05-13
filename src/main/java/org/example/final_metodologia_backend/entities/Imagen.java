package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="imagenes")
@NoArgsConstructor
@Setter
@Getter
public class Imagen extends Base{
    @Column
    private String url;

    @Column
    private String altDescripcion;

    public Imagen(String url, String altDescripcion) {
        this.url = url;
        this.altDescripcion = altDescripcion;
    }
}
