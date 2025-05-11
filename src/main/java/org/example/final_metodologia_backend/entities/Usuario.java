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

    @ManyToOne
    @JoinColumn(name="direccion_id")
    private Direccion direccion;

    @Column
    private String nombre;

    @Column
    private String contrasenia;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column
    private String email;

    @Column
    private Long dni;

    public Usuario(String nombre, String contrasenia, Rol rol, String email, Direccion direccion, Long dni) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.email = email;
        this.direccion = direccion;
        this.dni = dni;
    }
}
