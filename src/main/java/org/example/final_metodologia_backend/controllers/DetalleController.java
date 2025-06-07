package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.services.DetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetalleController extends BaseController<Detalle, Long> {

    private final DetalleService detalleService;

    public DetalleController(DetalleService detalleService) {
        super(detalleService);
        this.detalleService = detalleService;
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<List<Detalle>> obtenerPorProductoId(@PathVariable Long id) {
        List<Detalle> detalles = detalleService.obtenerDetallesPorProductoId(id);

        if (detalles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(detalles);
    }
}


