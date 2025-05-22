package org.example.final_metodologia_backend.Auth;

import org.example.final_metodologia_backend.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.entities.enums.Rol;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNombre(), request.getContrasenia()));
        UserDetails usuario = usuarioRepository.findByNombre(request.getNombre()).orElseThrow();
        String token = jwtService.getToken(usuario);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder().
                nombre(request.getNombre())
                .contrasenia(request.getContrasenia())
                .direccion(request.getDireccion())
                .email(request.getEmail())
                .dni(request.getDni())
                .rol(Rol.CLIENTE)
                .build();
        usuarioRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
