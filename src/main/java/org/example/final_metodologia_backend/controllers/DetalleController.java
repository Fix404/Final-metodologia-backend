package org.example.final_metodologia_backend.controllers;

import org.example.final_metodologia_backend.dto.CreateDetalleDto;
import org.example.final_metodologia_backend.dto.DetalleDto;
import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.services.DetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/dto")
    public ResponseEntity<List<DetalleDto>> listarDetallesDTO() {
        try {
            List<DetalleDto> detallesDTO = detalleService.listarDetallesDTO();
            return ResponseEntity.ok(detallesDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/dto")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetalleDto> crearDetalle(@RequestBody CreateDetalleDto createDetalleDto) {
        try {
            DetalleDto nuevoDetalle = detalleService.crearDetalle(createDetalleDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalle);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DetalleDto> actualizarDetalle(@PathVariable Long id, @RequestBody CreateDetalleDto createDetalleDto) {
        try {
            DetalleDto detalleActualizado = detalleService.actualizarDetalle(id, createDetalleDto);
            return ResponseEntity.ok(detalleActualizado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}


