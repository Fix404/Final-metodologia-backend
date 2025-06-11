package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.dto.CambioContraseniaDto;
import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.jwt.JwtService;
import org.example.final_metodologia_backend.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, Long> {

    private final UsuarioService usuarioService;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public UsuarioController(UsuarioService usuarioService,
                             UserDetailsService userDetailsService,
                             JwtService jwtService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PutMapping("/{id}/cambiar-contrasenia")
    public ResponseEntity<?> cambiarContrasenia(@PathVariable Long id, @RequestBody CambioContraseniaDto dto) {
        try {
            Usuario usuarioActualizado = usuarioService.cambiarContrasenia(id, dto.getContraseniaActual(), dto.getContraseniaNueva());

            UserDetails userDetails = userDetailsService.loadUserByUsername(usuarioActualizado.getUsername());
            String nuevoToken = jwtService.getToken(userDetails);

            Map<String, Object> response = new HashMap<>();
            response.put("usuario", usuarioActualizado);
            response.put("token", nuevoToken);

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
