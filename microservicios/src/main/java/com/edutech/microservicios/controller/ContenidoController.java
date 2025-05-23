package com.edutech.microservicios.controller;

import com.edutech.microservicios.model.Contenido;
import com.edutech.microservicios.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<Contenido> getAllContenidos() {
        return contenidoService.getAllContenidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> getContenidoById(@PathVariable Long id) {
        return contenidoService.getContenidoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contenido createContenido(@RequestBody Contenido contenido) {
        return contenidoService.createContenido(contenido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> updateContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        try {
            Contenido updated = contenidoService.updateContenido(id, contenido);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenido(@PathVariable Long id) {
        contenidoService.deleteContenido(id);
        return ResponseEntity.noContent().build();
    }
}
