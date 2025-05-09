package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Talle;
import org.example.final_metodologia_backend.services.TalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talles")
public class TalleController extends BaseController<Talle, Long>{
    public TalleController(TalleService talleService){
        super(talleService);
    }
}
