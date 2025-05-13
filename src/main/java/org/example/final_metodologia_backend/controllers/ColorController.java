package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Color;
import org.example.final_metodologia_backend.services.ColorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colores")
public class ColorController extends BaseController<Color, Long>{
    public ColorController(ColorService colorService){
        super(colorService);
    }
}