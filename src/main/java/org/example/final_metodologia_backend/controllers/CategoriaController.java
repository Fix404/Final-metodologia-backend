package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Categoria;
import org.example.final_metodologia_backend.services.CategoriaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController<Categoria, Long>{
    public CategoriaController(CategoriaService categoriaService){
        super(categoriaService);
    }
}
