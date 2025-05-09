package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, Long>{
    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
    }
}
