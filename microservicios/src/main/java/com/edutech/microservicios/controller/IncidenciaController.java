package com.edutech.microservicios.controller;

import com.edutech.microservicios.model.Incidencia;
import com.edutech.microservicios.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public List<Incidencia> getAllIncidencias() {
        return incidenciaService.getAllIncidencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> getIncidenciaById(@PathVariable Long id) {
        return incidenciaService.getIncidenciaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Incidencia createIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaService.createIncidencia(incidencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> updateIncidencia(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        try {
            Incidencia updated = incidenciaService.updateIncidencia(id, incidencia);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncidencia(@PathVariable Long id) {
        incidenciaService.deleteIncidencia(id);
        return ResponseEntity.noContent().build();
    }
}
