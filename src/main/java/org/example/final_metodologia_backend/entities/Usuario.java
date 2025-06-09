package org.example.final_metodologia_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.final_metodologia_backend.entities.enums.Rol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@Table(name="usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = ("nombre"))})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario extends Base implements UserDetails {

    @ManyToOne
    @JoinColumn(name="direccion_id")
    private Direccion direccion;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String contrasenia;

    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column
    private String email;

    @Column
    private Long dni;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.name()));
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
