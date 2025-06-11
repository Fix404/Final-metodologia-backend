package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Long> {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario crearUsuario(Usuario usuario) {
        // Encriptar contraseña antes de guardar
        String contraseniaEncriptada = passwordEncoder.encode(usuario.getContrasenia());
        usuario.setContrasenia(contraseniaEncriptada);
        return repository.save(usuario);
    }

    public Usuario cambiarContrasenia(Long id, String contraseniaActual, String contraseniaNueva) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Validar contraseña actual
        if (!passwordEncoder.matches(contraseniaActual, usuario.getContrasenia())) {
            throw new RuntimeException("La contraseña actual es incorrecta");
        }

        // Encriptar y actualizar nueva contraseña
        usuario.setContrasenia(passwordEncoder.encode(contraseniaNueva));
        return repository.save(usuario);
    }

}
