package org.example.final_metodologia_backend.repositories;

import org.example.final_metodologia_backend.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByNombre(String nombre);

}
