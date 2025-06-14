package org.example.final_metodologia_backend.controllers;

import jakarta.transaction.Transactional;
import org.example.final_metodologia_backend.entities.Base;
import org.example.final_metodologia_backend.services.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseController<E extends Base, ID extends Serializable> {
    protected BaseService<E, ID> service;


    public BaseController(BaseService<E, ID> service) {this.service=service;}

    @GetMapping()
    public ResponseEntity<List<E>> listar() throws Exception {
        List<E> entities = service.listar();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<E>> listarActivos() {
        try {
            return ResponseEntity.ok(service.listarActivos());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public Optional<E> buscarPorId(@PathVariable ID id) throws Exception {
        return service.buscarPorId(id);
    }

    @PostMapping()
    public ResponseEntity<E> crear(@RequestBody E entity) throws Exception {
        E entidadCreada = service.crear(entity);
        return ResponseEntity.ok(entidadCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> actualizar(@RequestBody E entity) throws Exception {
        E entidadAct = service.actualizar(entity);
        return ResponseEntity.ok(entidadAct);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable ID id) throws Exception {
        service.eliminar(id);
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<Void> cambiarEstado(@PathVariable ID id, @RequestParam boolean activo) throws Exception {
        service.cambiarEstado(id, activo);
        return ResponseEntity.noContent().build();
    }


}
