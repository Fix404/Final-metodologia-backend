package org.example.final_metodologia_backend.adminInitializer;

import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.entities.enums.Rol;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    public AdminInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByNombre("admin").isEmpty()) {
            Usuario admin = Usuario.builder()
                    .nombre("admin")
                    .contrasenia(passwordEncoder.encode(adminPassword))
                    .email(adminEmail)
                    .rol(Rol.ADMIN)
                    .build();
            usuarioRepository.save(admin);
            System.out.println("Usuario administrador creado con éxito.");
        } else {
            System.out.println("Ya existe un usuario admin.");
        }
    }
}
