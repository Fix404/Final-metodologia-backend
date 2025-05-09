package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Imagen;
import org.example.final_metodologia_backend.services.ImagenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagenes")
public class ImagenController extends BaseController<Imagen, Long>{
    public ImagenController(ImagenService imagenService){
        super(imagenService);
    }
}
