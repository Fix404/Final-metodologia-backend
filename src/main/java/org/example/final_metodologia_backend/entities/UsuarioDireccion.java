package org.example.final_metodologia_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="direcciones_usuarios")
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDireccion extends Base{
    @Column(name="id_usuario")
    //Clave foránea
    private Integer idDUsuario;

    @Column(name="id_direccion")
    // Clave foránea
    private Integer idDireccion;

}
