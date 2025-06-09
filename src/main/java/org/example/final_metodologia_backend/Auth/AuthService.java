package org.example.final_metodologia_backend.Auth;

import org.example.final_metodologia_backend.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.entities.enums.Rol;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getContrasenia()));
        UserDetails usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .contrasenia(passwordEncoder.encode(request.getContrasenia()))
                .email(request.getEmail())
                .rol(Rol.CLIENTE)
                .build();
            usuario = usuarioRepository.save(usuario);


        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
