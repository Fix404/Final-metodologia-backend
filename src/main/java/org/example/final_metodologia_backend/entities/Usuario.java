package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.final_metodologia_backend.entities.enums.Rol;

@Entity
@Table(name="usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario extends Base{
    @Column
    private String nombre;

    @Column
    private String contrasena;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column
    private String email;

    @Column
    private String direccion;

    @Column
    private Number dni;

    public Usuario(String nombre, String contrasena, Rol rol, String email, String direccion, Number dni) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.email = email;
        this.direccion = direccion;
        this.dni = dni;
    }
}
